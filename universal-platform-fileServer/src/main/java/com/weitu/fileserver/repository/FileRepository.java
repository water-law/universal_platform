package com.weitu.fileserver.repository;

import com.weitu.fileserver.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * File 存储库.
 * 
 * @since 1.0.0 2017年3月28日
 * @author linzl
 */
public interface FileRepository extends MongoRepository<File, String> {
}
