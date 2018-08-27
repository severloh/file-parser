package com.silvester.fileparser.utils;

import com.silvester.fileparser.FileType;
import com.silvester.fileparser.exception.FileExtNotFoundException;
import com.silvester.fileparser.exception.FileUnKnownException;

import java.util.Objects;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 15:28
 */

public class FileUtils {

    public static FileType determinate(String fileName) {
        String[] strings = fileName.split("\\.");
        if (strings.length == 0) {
            throw new FileExtNotFoundException(String.format("fileName : %s ext not found", fileName));
        }
        final String fileType = strings[strings.length - 1].toLowerCase();
        FileType file = FileType.getFileTypeByExt(fileType);
        if (Objects.equals(file, FileType.UN_KNOWN_FILE)) {
            throw new FileUnKnownException("unknown file");
        }
        return file;
    }

}
