/**
 *
 */
package com.weitu.fileserver.service;

import com.weitu.fileserver.domain.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;


/**
 * File 服务接口.
 *
 * @author linzl
 * @since 1.0.0 2017年3月28日
 */
public interface FileService {
	/**
	 * 保存文件
	 *
	 * @param File
	 * @return
	 */
	File saveFile(File file);

	/**
	 * 删除文件
	 *
	 * @param File
	 * @return
	 */
	void removeFile(String id);

	/**
	 * 根据id获取文件
	 *
	 * @param File
	 * @return
	 */
	Optional<File> getFileById(String id);

	/**
	 * 分页查询，按上传时间降序
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<File> listFilesByPage(int pageIndex, int pageSize);

	/**
	 * 上传文件（断点续传）
	 * @param file
	 * @param in
	 * @return
	 * @throws IOException
	 */
	File uploadFile(File file, InputStream in) throws IOException;

	/**
	 * 根据url下载文件到磁盘
	 * @param downloadUrl
	 * @param orgiFileName
	 * @return
	 */
	File uploadFileByUrl(String downloadUrl, String orgiFileName);
}
