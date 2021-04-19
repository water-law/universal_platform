package com.weitu.fileserver.controller;

import com.weitu.fileserver.domain.CustomUploadFile;
import com.weitu.fileserver.domain.File;
import com.weitu.fileserver.service.FileService;
import com.weitu.fileserver.util.MD5Util;
import com.weitu.fileserver.util.SUUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600) // 允许所有域名访问
@Controller
@Api(value = "文件服务")
@RequestMapping("/fileservice")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileService fileService;

	@Value("${server.host-url}")
	private String serverUrl;


	public static final String IMAGE = "image";
	public static final String DOCUMENT = "document";
	public static final String PDF = "pdf";
	public static final String AUDIO = "audio";
	public static final String VIDEO = "video";

	@Value("${file.type.imageSize}")
	private String imageSize;

	@Value("${file.type.txtSize}")
	private String txtSize;

	@Value("${file.type.audioSize}")
	private String audioSize;

	@Value("${file.type.videoSize}")
	private String videoSize;


	/**
	 * 获取文件片信息
	 * 
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("files/{id}")
	@ResponseBody
	@ApiOperation("下载文件")
	public ResponseEntity<Object> serveFile(HttpServletRequest request, @PathVariable String id) throws UnsupportedEncodingException {

		Optional<File> file = fileService.getFileById(id);

		if (file.isPresent()) {
            //response.setCharacterEncoding("utf-8");
            String fileName = file.get().getName();
            String userAgent = "";
            if (request != null && request.getHeader("user-agent") != null) {
                userAgent = request.getHeader("user-agent").toLowerCase();
            }
            if (userAgent.contains("msie") || userAgent.contains("like gecko") ) {
                // win10 ie edge 浏览器 和其他系统的ie
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                //其他的浏览器
                fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
            }
			return ResponseEntity.ok()
					//.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
					//.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header("Character-Encoding", "utf-8")
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + fileName)
                    .header(HttpHeaders.CONTENT_TYPE, "multipart/form-data")
					.header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
					.body(file.get().getContent().getData());
		}
        logger.error("File was not fount");
        return ResponseEntity.ok().body(null);

	}

	/**
	 * 根据id获取文件信息
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/info/{id}")
	@ResponseBody
	@ApiOperation("根据id获取文件概要信息")
	public ResponseEntity<Object> getFileInfo(@PathVariable String id) {

		Optional<File> file = fileService.getFileById(id);
        if (file.isPresent()) {
            file.get().setContent(null);
            file.get().setUrl(serverUrl+"/fileservice/view/"+id);
            return ResponseEntity.ok()
                    .body(file.get());
        }
        logger.error("File was not fount");
        return ResponseEntity.ok().body(null);

	}

	/**
	 * 在线显示文件
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	@ResponseBody
	@ApiOperation("根据id在线显示文件")
	public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

		Optional<File> file = fileService.getFileById(id);

		if (file.isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
					.header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
					.header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
					.body(file.get().getContent().getData());
		}
        logger.error("File was not fount");
        return ResponseEntity.ok().body(null);

	}


    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadWithRetFile")
    @ResponseBody
    @ApiOperation("文件上传接口,返回文件对象")
    public ResponseEntity<Object> handleFileUploadWithRetFile(@RequestParam("file") MultipartFile file) {
        File returnFile = null;
        try {
            // 校验文件格式
            if (!checkFileLayout(file)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件格式不对!");
            }
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            returnFile = fileService.saveFile(f);
            if (returnFile != null) {
                returnFile.setContent(null);
                returnFile.setUrl(serverUrl+"/fileservice/view/"+returnFile.getId());
                return ResponseEntity.status(HttpStatus.OK).body(returnFile);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传失败");

        } catch (IOException | NoSuchAlgorithmException ex) {
            logger.error("文件上传失败！{}", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }



    /**
	 * 上传接口
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	@ApiOperation("文件上传接口,仅返回文件id")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		File returnFile = null;
		try {
            // 校验文件格式
            if (!checkFileLayout(file)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件格式不对!");
            }
			File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
					new Binary(file.getBytes()));
			f.setMd5(MD5Util.getMD5(file.getInputStream()));
			returnFile = fileService.saveFile(f);
            if (returnFile != null) {
                String fileId = returnFile.getId();
                return ResponseEntity.status(HttpStatus.OK).body(fileId);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传失败");

		} catch (IOException | NoSuchAlgorithmException ex) {
            logger.error("文件上传失败！{}", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

    /**
     * 上传接口(自定义文件对象)
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadWithRetFileByCustom")
    @ResponseBody
    @ApiOperation("文件上传接口,返回文件对象")
    public ResponseEntity<Object> handleFileUploadWithRetFile(@RequestBody CustomUploadFile file) {
        File returnFile;
        try {
            // 校验文件格式
            if (!checkFileName(file.getOriginalFilename())) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件格式不对!");
            }
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            returnFile = fileService.saveFile(f);
            if (returnFile != null) {
                returnFile.setContent(null);
                returnFile.setUrl(serverUrl+"/fileservice/view/"+returnFile.getId());
                return ResponseEntity.status(HttpStatus.OK).body(returnFile);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传失败");

        } catch (Exception ex) {
            logger.error("文件上传失败！{}", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    /**
     * 上传接口(自定义文件对象)
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadBase64WithRetIdByCustom")
    @ResponseBody
    @ApiOperation("base64字符串文件上传接口,仅返回Id")
    public ResponseEntity<String> uploadBase64WithRetIdByCustom(@RequestBody CustomUploadFile file) {
        File returnFile;
        try {
            // 校验文件格式
            if (!checkFileName(file.getOriginalFilename())) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件格式不对!");
            }
            byte[] bytes = Base64.getMimeDecoder().decode(file.getBase64Str());
            file.setSize(Long.valueOf(String.valueOf(bytes.length)));
            if (StringUtils.isEmpty(file.getOriginalFilename())) {
                file.setOriginalFilename(SUUID.getUUID());
            }
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(bytes));
            returnFile = fileService.saveFile(f);
            if (returnFile != null) {
                return ResponseEntity.status(HttpStatus.OK).body(returnFile.getId());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传失败");
        } catch (Exception ex) {
            logger.error("文件上传失败！{}", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

	/**
	 * 删除文件
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@ResponseBody
	@ApiOperation("根据文件Id删除文件")
	public ResponseEntity<String> deleteFile(@PathVariable String id) {

		try {
			fileService.removeFile(id);
			return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
		} catch (Exception e) {
            logger.error("文件删除失败！{}", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

    /**
     * 在线显示文件(增加了文件名)
     *
     * @param id
     * @param fileName 文件名称
     * @return
     */
    @GetMapping("/view/{id}/{fileName}")
    @ResponseBody
    @ApiOperation("根据id在线显示文件")
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id,@PathVariable String fileName) {

        Optional<File> file = fileService.getFileById(id);

        if (file.isPresent()) {
            String fileNameNew = id;
            if (fileName != null && fileName != "") {
                fileNameNew = fileName;
            } else if (file.get() != null
                    && file.get().getName() != null
                    && file.get().getName() != "") {
                fileNameNew = file.get().getName();
            }
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + fileNameNew + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        }
        logger.error("File was not fount");
        return ResponseEntity.ok().body(null);

    }

    /**
     * 功能描述: 校验文件上传格式
     * @Author: senhuaF
     * @CreateDate: 2019/12/11 10:21
     * @Return:
     * @Version 1.0
     **/
    private boolean checkFileLayout (MultipartFile file) {
        //获取文件全名
        //file.getOriginalFilename();
        //首先判断是不是空的文件
        if (!file.isEmpty()) {
            // 对文文件的全名进行截取然后在后缀名进行删选。
            int begin = file.getOriginalFilename().lastIndexOf(".");
            int last = file.getOriginalFilename().length();
            // 获得文件后缀名
            String a = file.getOriginalFilename().substring(begin, last);
            // 需要的文件如下，如果有其它格式重新补
            if (a.equalsIgnoreCase(".jpg") ||a.equalsIgnoreCase(".bmp") || a.equalsIgnoreCase(".png") ||
                    a.equalsIgnoreCase(".jpeg") || a.equalsIgnoreCase(".pdf")
                    || a.equalsIgnoreCase(".xlsx") || a.equalsIgnoreCase(".xls")
                    || a.equalsIgnoreCase(".docx") || a.equalsIgnoreCase(".doc")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkFileName(String fileName) {
        if (!"null".equals(fileName) && !"".equals(fileName)) {
            //对文文件的全名进行截取然后在后缀名进行删选。
            int begin = fileName.lastIndexOf(".");
            int last = fileName.length();
            //获得文件后缀名
            String a = fileName.substring(begin, last);
            // 需要的文件如下，如果有其它格式重新补
			if (a.equalsIgnoreCase(".jpg") ||a.equalsIgnoreCase(".bmp") || a.equalsIgnoreCase(".png") ||
					a.equalsIgnoreCase(".jpeg") || a.equalsIgnoreCase(".pdf")
					|| a.equalsIgnoreCase(".xlsx") || a.equalsIgnoreCase(".xls")
					|| a.equalsIgnoreCase(".docx") || a.equalsIgnoreCase(".doc")
					//增加音频格式
					|| a.equalsIgnoreCase(".wav") || a.equalsIgnoreCase(".mp3") || a.equalsIgnoreCase(".aac")
					//增加视频格式
					|| a.equalsIgnoreCase(".mpg") || a.equalsIgnoreCase(".mp4")
					|| a.equalsIgnoreCase(".flv") || a.equalsIgnoreCase(".avi")) {
                return true;
            }
        }
        return false;
    }

	@PostMapping("/disk/upload")
	@ResponseBody
	@ApiOperation(value = "续传上传文件保存到磁盘")
	public ResponseEntity<Object> uploadInDisk(@RequestParam(value = "file") MultipartFile file) {
		System.out.println("================================");
		System.out.println(file.getOriginalFilename());
		File returnFile = null;
		try {
			// 校验文件格式
			if (!checkFileName(file.getOriginalFilename())) {
				logger.error("上传文件保存到磁盘，上传文件格式不对!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件保存到磁盘，上传文件格式不对!");
			}
			// 获取文件格式
			String fileType = checkStringFileLayout(file);
			if ("".equals(fileType)) {
				logger.error("上传文件保存到磁盘，上传文件格式不对!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传文件保存到磁盘，上传文件格式不对!");
			}
			long fileSize = file.getSize();
			if (IMAGE.equals(fileType) && fileSize > Long.parseLong(imageSize)){
				logger.error("上传文件保存到磁盘，上传的图片文件太大!" + fileSize/1024/1024 + "M");
				return ResponseEntity.status(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE).body("上传文件保存到磁盘，上传的图片文件太大!");
			}else if (DOCUMENT.equals(fileType) && fileSize > Long.parseLong(txtSize)){
				logger.error("上传文件保存到磁盘，上传的文档文件太大!" + fileSize/1024/1024 + "M");
				return ResponseEntity.status(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE).body("上传文件保存到磁盘，上传的文档文件太大!");
			}else if (AUDIO.equals(fileType) && fileSize > Long.parseLong(audioSize)){
				logger.error("上传文件保存到磁盘，上传的音频文件太大!" + fileSize/1024/1024 + "M");
				return ResponseEntity.status(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE).body("上传文件保存到磁盘，上传的音频文件太大!");
			}else if (VIDEO.equals(fileType) && fileSize > Long.parseLong(videoSize)){
				logger.error("上传文件保存到磁盘，上传的视频文件太大!" + fileSize/1024/1024 + "M");
				return ResponseEntity.status(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE).body("上传文件保存到磁盘，上传的视频文件太大!");
			}

			InputStream in =file.getInputStream();
			File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
					null);
			f.setMd5(MD5Util.getMD5(file.getInputStream()));
			returnFile = fileService.uploadFile(f,in);
			if (returnFile != null) {
				System.out.println("name:" + returnFile.getName() + "contentType:" + returnFile.getContentType());
				if (returnFile.getSize() == -2) {
					logger.error("上传文件保存到磁盘，存放路径不存在");
					return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
				}else if (returnFile.getSize() == -1){
					logger.error("上传文件保存到磁盘，文件已存在");
					return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
				}else{
					String fileId = returnFile.getId();
					return ResponseEntity.status(HttpStatus.OK).body(fileId);
				}
			}
			logger.error("上传文件保存到磁盘，上传失败");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		} catch (IOException | NoSuchAlgorithmException ex) {
			System.out.println(ex);
			logger.error("上传文件保存到磁盘，文件上传失败！{}", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping("/disk/info/{id}")
	@ResponseBody
	@ApiOperation("根据id获取磁盘中文件概要信息")
	public ResponseEntity<Object> getFileInfoInDisk(@PathVariable String id) {

		Optional<File> file = fileService.getFileById(id);
		if (file.isPresent()) {
			file.get().setContent(null);
			file.get().setUrl(serverUrl+"/fileservice/disk/view/"+id);
			return ResponseEntity.ok()
					.body(file.get());
		}
		logger.error("根据id获取磁盘中文件概要信息，文件不存在");
		return ResponseEntity.ok().body(null);

	}

	@GetMapping("disk/files/{id}")
	@ResponseBody
	@ApiOperation("磁盘下载文件")
	public ResponseEntity<Object> serveFileDisk(HttpServletRequest request, @PathVariable String id) throws IOException {

		Optional<File> file = fileService.getFileById(id);
		byte[] bytes=null;
		if (file.isPresent()) {
			//response.setCharacterEncoding("utf-8");
			String fileName = file.get().getName();
			String userAgent = "";
			String filePath = file.get().getPath();
			java.io.File filebyte = new java.io.File(filePath);
			bytes = com.google.common.io.Files.toByteArray(filebyte);
			if (request != null && request.getHeader("user-agent") != null) {
				userAgent = request.getHeader("user-agent").toLowerCase();
			}
			if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
				// win10 ie edge 浏览器 和其他系统的ie
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				//其他的浏览器
				fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
			}
			return ResponseEntity.ok()
					//.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
					//.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
					.header("Character-Encoding", "utf-8")
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + fileName)
					.header(HttpHeaders.CONTENT_TYPE, "multipart/form-data")
					.header(HttpHeaders.CONTENT_LENGTH, filebyte.length() + "").header("Connection", "close")
					.body(bytes);
		}
		logger.error("File was not fount");
		return ResponseEntity.ok().body(null);

	}


	@PostMapping("/disk/uploadFileInfo")
	@ResponseBody
	@ApiOperation(value = "保存文件信息")
	public ResponseEntity<Object> uploadFileInfo(@RequestBody File file) {
    	if(null == file || StringUtils.isEmpty(file.getName()) || StringUtils.isEmpty(file.getContentType())){
			logger.error("保存文件信息失败!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("保存文件信息失败,信息不完整!");
		}
		File returnFile = null;
		returnFile = fileService.saveFile(file);
		if (returnFile != null) {
			String fileId = returnFile.getId();
			return ResponseEntity.status(HttpStatus.OK).body(fileId);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("保存失败");
	}

	@PostMapping("/disk/uploadByUrl")
	@ResponseBody
	@ApiOperation(value = "根据url地址文件保存到磁盘")
	public ResponseEntity<Object> uploadByUrl(@RequestParam(value = "downloadUrl") String downloadUrl, @RequestParam(value = "orgiFileName") String orgiFileName) {
		File returnFile  = fileService.uploadFileByUrl(downloadUrl,orgiFileName);
    	if (returnFile != null) {
			return ResponseEntity.ok()
					.body(returnFile.getId());
		}
		logger.error("根据id获取磁盘中文件概要信息，文件不存在");
		return ResponseEntity.ok().body(null);
	}
	/**
	 * 功能描述: 校验文件上传格式
	 * @Author: senhuaF
	 * @CreateDate: 2019/12/11 10:21
	 * @Return:
	 * @Version 1.0
	 **/
	private String checkStringFileLayout (MultipartFile file) {
		//获取文件全名
		//file.getOriginalFilename()
		// 首先判断是不是空的文件
		if (!file.isEmpty()) {
			// 对文文件的全名进行截取然后在后缀名进行删选。
			int begin = file.getOriginalFilename().lastIndexOf(".");
			int last = file.getOriginalFilename().length();
			// 获得文件后缀名
			String a = file.getOriginalFilename().substring(begin, last);
			// 需要的文件如下，如果有其它格式重新补
			if (a.equalsIgnoreCase(".jpg")
					|| a.equalsIgnoreCase(".bmp")
					|| a.equalsIgnoreCase(".png")
					|| a.equalsIgnoreCase(".jpeg")) {
				return IMAGE;
			}else //文件格式
				if (a.equalsIgnoreCase(".pdf")
//                    || a.equalsIgnoreCase(".xlsx")
//                    || a.equalsIgnoreCase(".xls")
						|| a.equalsIgnoreCase(".docx")
						|| a.equalsIgnoreCase(".doc")){
					return DOCUMENT;
				}else //增加音频格式
					if (a.equalsIgnoreCase(".wav")
							|| a.equalsIgnoreCase(".mp3")
							|| a.equalsIgnoreCase(".aac")){
						return AUDIO;
					}else //增加视频格式
						if (a.equalsIgnoreCase(".mpg")
								|| a.equalsIgnoreCase(".mp4")
								|| a.equalsIgnoreCase(".flv")
								|| a.equalsIgnoreCase(".avi")){
							return VIDEO;
						}
		}
		return "";
	}

}
