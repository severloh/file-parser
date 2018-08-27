package com.silvester.fileparser;

import java.io.IOException;
import java.io.InputStream;


public interface FileParserFactory {
    /**
     * 文件解析
     *
     * @param fileName    文件名称，包含后缀
     * @param inputStream 输入流对象
     * @param group       业务分组
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T parse(String fileName, InputStream inputStream, Class group) throws IOException;

    /**
     * 默认分组的文件解析
     *
     * @param fileName    文件名称，包含后缀
     * @param inputStream 输入流对象
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T parse(String fileName, InputStream inputStream) throws IOException;

}
