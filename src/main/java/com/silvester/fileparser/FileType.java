package com.silvester.fileparser;

import java.util.Objects;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 15:22
 */

public enum FileType {
    EXCEL_XLS("excel", "xls"),
    EXCEL_XLSX("excel", "xlsx"),
    UN_KNOWN_FILE("none", "none");
    /**
     * 文件类型
     */
    private final String type;
    /**
     * 扩展名
     */
    private final String ext;

    FileType(String type, String ext) {
        this.type = type;
        this.ext = ext;
    }

    public String getType() {
        return type;
    }

    public String getExt() {
        return ext;
    }

    public static FileType getFileTypeByExt(String ext) {
        FileType[] fileTypes = FileType.values();
        for (int i = 0; i < fileTypes.length; i++) {
            if (Objects.equals(ext, fileTypes[i].getExt())) {
                return fileTypes[i];
            }
        }
        return UN_KNOWN_FILE;
    }

}
