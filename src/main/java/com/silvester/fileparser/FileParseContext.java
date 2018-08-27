package com.silvester.fileparser;

import java.io.InputStream;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 15:22
 */

public class FileParseContext<T> {
    private String fileName;
    /**
     * 文件枚举
     */
    private FileType fileType;
    /**
     * 流对象
     */
    private InputStream inputStream;
    /**
     * 解析后的结果
     */
    private T result;

    public FileParseContext() {

    }

    public FileParseContext(String fileName, InputStream inputStream) {
        this.fileName = fileName;
        this.inputStream = inputStream;
    }

    public FileParseContext(String fileName, FileType fileType, InputStream inputStream) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
