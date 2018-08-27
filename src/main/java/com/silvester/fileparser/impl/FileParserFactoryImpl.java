package com.silvester.fileparser.impl;


import com.silvester.fileparser.*;
import com.silvester.fileparser.annotation.Parser;
import com.silvester.fileparser.exception.FileParserDuplicateException;
import com.silvester.fileparser.exception.FileParserException;
import com.silvester.fileparser.exception.FileParserNotFoundException;
import com.silvester.fileparser.utils.FileUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 15:44
 */
public class FileParserFactoryImpl implements FileParserFactory {
    private static Map<String, FileParser> fileParserMapping = new HashMap<>();

    public static FileParser add(FileParser fileParser){
        Parser parser = fileParser.getClass().getDeclaredAnnotation(Parser.class);
        Class group = parser.group();
        FileType[] fileTypes = parser.support();
        if (fileTypes.length == 0) {
            throw new FileParserException(String.format("the Parser named %s 'support fileTypes array can not be empty 。", fileParser.getClass().getName()));
        }
        for (int i = 0; i < fileTypes.length; i++) {
            String key = generateKey(group, fileTypes[i]);
            if (fileParserMapping.containsKey(key)) {
                throw new FileParserDuplicateException(String.format("the bean %s is duplicate FileParser in group :%s fileType :%s", fileParser.getClass().getName(), group.getName(), fileTypes[i].name()));
            }
            fileParserMapping.put(key, fileParser);
        }
        return fileParser;
    }
    private static String generateKey(Class clz, FileType fileType) {
        return String.format("%s-%s", clz.getName(), fileType.name());
    }


    @Override
    public <T> T parse(String fileName, InputStream inputStream, Class group) throws IOException {
        //入参校验
        validate(fileName, inputStream, group);
        //构建上下文
        FileParseContext<T> fileParseContext = new FileParseContext<>(fileName,FileUtils.determinate(fileName),inputStream);

        //查找解析器
        FileParser<T> fileParser = determinateFileParser(fileParseContext.getFileType(), group);

        return fileParser.parse(fileParseContext);


    }

    @Override
    public <T> T parse(String fileName, InputStream inputStream) throws IOException {
        return parse(fileName, inputStream, Default.class);
    }

    private <T> FileParser<T> determinateFileParser(FileType fileType, Class group) {

        FileParser fileParser = fileParserMapping.get(generateKey(group, fileType));
        if (fileParser == null) {
            throw new FileParserNotFoundException(String.format("the parser in group : %s ,fileType: %s not found", group.getName(), fileType.name()));
        }
        return fileParser;
    }

    private void validate(String fileName, InputStream inputStream, Class group) {
        if (StringUtils.isEmpty(fileName)) {
            throw new FileParserException("the fileName can not be empty.");
        }
        if (null == inputStream) {
            throw new FileParserException("the file inputStream can not be null.");
        }
        if (group == null) {
            throw new FileParserException("the FileParser group can not be null");
        }
    }

}
