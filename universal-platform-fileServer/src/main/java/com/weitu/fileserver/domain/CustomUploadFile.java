package com.weitu.fileserver.domain;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 文件上传对象
 */
public class CustomUploadFile implements Serializable {
    private String originalFilename;
    private String contentType;
    private long size;
    private byte[] bytes;
    private String base64Str;
    private InputStream inputStream;

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getBase64Str() {
        return base64Str;
    }

    public void setBase64Str(String base64Str) {
        this.base64Str = base64Str;
    }

    @Override
    public String toString() {
        return "CustomUploadFile{" +
                "originalFilename='" + originalFilename + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", bytes=" + Arrays.toString(bytes) +
                ", base64Str='" + base64Str + '\'' +
                ", inputStream=" + inputStream +
                '}';
    }
}
