package com.weitu.fileserver.service;

import com.weitu.fileserver.domain.File;
import com.weitu.fileserver.repository.FileRepository;
import com.weitu.fileserver.util.SUUID;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * File 服务.
 * 
 * @since 1.0.0 2017年7月30日
 * @author linzl
 */
@Service
public class FileServiceImpl implements FileService {

	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	public FileRepository fileRepository;

	@Value("${file.realSavePath}")
	private String realSavePath;

	@Override
	public File saveFile(File file) {
		return fileRepository.save(file);
	}

	@Override
	public void removeFile(String id) {
		fileRepository.delete(id);
	}

	@Override
	public Optional<File> getFileById(String id) {
		return Optional.ofNullable(fileRepository.findOne(id));
	}

	@Override
	public List<File> listFilesByPage(int pageIndex, int pageSize) {
		Page<File> page = null;
		List<File> list = null;
		
		Sort sort = new Sort(Direction.DESC,"uploadDate"); 
		Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
		
		page = fileRepository.findAll(pageable);
		list = page.getContent();
		return list;
	}

	@Override
	public File uploadFile(File file, InputStream in) throws IOException {
		File returnFile = null;
		String path = "";
		try {
			String tempFileName = file.getMd5() + "_" + SUUID.getUUID();
			String fileName = tempFileName + "." + file.getPostfix();
			Date date = new Date();
			String dataForm = new SimpleDateFormat("yyyy-MM-dd").format(date);
			//文件保存路径
			path = realSavePath + dataForm + "/";
			logger.info(path);
			//文件全路径
			String filePath = path+fileName;
			file.setPath(filePath);
			logger.info(filePath);

			java.io.File realFile = new java.io.File(path + fileName);
			java.io.File tempFile = new java.io.File(path + tempFileName +".temp");
			if (!checkPath(path)){
				returnFile = file;
				returnFile.setSize(-2);
				return file;
			}
			if (realFile.exists()) {
				returnFile = file;
				returnFile.setSize(-1);
				// 文件已经传输成功
				return file;
			} else {
				long needSkipBytes = 0;
				if (tempFile.exists()) {
					// 续传
					needSkipBytes = tempFile.length();
				} else {
					// 第一次传
					tempFile.createNewFile();
				}
				logger.info("跳过的字节数为：" + needSkipBytes);
				in.skip(needSkipBytes);
				RandomAccessFile tempRandAccessFile = new RandomAccessFile(tempFile, "rw");
				tempRandAccessFile.seek(needSkipBytes);
				byte[] buffer = new byte[1024];
				int len = 0;
				// 判断是否第一次写入成功
				boolean inputFlag = true;
				while ((len = in.read(buffer)) != -1) {
					tempRandAccessFile.write(buffer,0,len);
					if (inputFlag){
						returnFile = fileRepository.save(file);
						inputFlag = false;
					}
				}
				in.close();
				tempRandAccessFile.close();
				if (fileCopy(tempFile, realFile)) {
					tempFile.delete();
				}
			}
		}catch (Exception e){
			logger.error("文件上传到磁盘时失败！{}", e);
			return null;
		}finally {
			in.close();
			Runtime run = Runtime.getRuntime();
			run.exec("chown -R nginx:nginx " + path);
		}
		return returnFile;
	}

	@Override
	public File uploadFileByUrl(String downloadUrl, String orgiFileName) {
		if(StringUtils.isBlank(downloadUrl)){
			return null;
		}
		URL url = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String filePath = "";
		String path = "";
		try {
			url = new URL(downloadUrl);
			// 打开连接
			URLConnection con = url.openConnection();
			// 请求超时:5s
			con.setConnectTimeout(5 * 1000);
			inputStream = con.getInputStream();
			if(StringUtils.isBlank(orgiFileName)){
				orgiFileName = downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1);
			}
			File fileInfo = new File(
					orgiFileName,con.getContentType(), con.getContentLength(),null);
			String tempFileName = SUUID.getUUID();
			String postfix = orgiFileName.substring(orgiFileName.lastIndexOf(".")+1, orgiFileName.length());
			String fileName = tempFileName + "." + postfix;
			String dataForm = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			//文件保存路径
			path = realSavePath + dataForm + "/";
			//文件全路径
			filePath = path+fileName;
			fileInfo.setPath(filePath);
			fileInfo.setPostfix(postfix);
			byte[] bytes = new byte[1024];
			// 读取到的数据长度
			int length;
			java.io.File savePath = new java.io.File(path);
			if (!savePath.exists()) {
				// 如果不存在当前文件夹，则创建该文件夹
				boolean mkdir = savePath.mkdirs();
				if (!mkdir) {
					System.out.println("创建文件夹失败");
					return null;
				}
			}
			outputStream = new FileOutputStream(filePath);
			// 读取
			while ((length = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, length);
			}
			return fileRepository.save(fileInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("复制文件失败：" + e.getMessage());
			return null;
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();

				}
				if (outputStream != null) {
					outputStream.close();

				}
				if(StringUtils.isNotBlank(path)) {
					Runtime run = Runtime.getRuntime();
					run.exec("chown -R nginx:nginx " + path);
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("复制文件失败：" + e.getMessage());
			}
		}
	}

	/**
	 *  判断路径是否存在，不存在创建路径
	 * @Author: wucong
	 * @param: [path]
	 * @return boolean
	 * @CreateDate: 2020/4/23 17:29
	 * @Version 1.0
	 */
	private boolean checkPath(String path){
		try {
			java.io.File dirPath = new java.io.File(path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		} catch (Exception e) {
			System.out.println("创建多层目录操作出错: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 将完成的文件载到指定位置
	 * @param sourceFile 缓存文件
	 * @param targetFile 指定文件地址
	 * @return
	 */
	private boolean fileCopy(java.io.File sourceFile, java.io.File targetFile) {
		boolean success = true;
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile),1024);
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile),1024);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer,0,len);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			success = false;
		} catch (IOException e) {
			success = false;
		}
		return success;
	}

}
