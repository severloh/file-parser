package com.silvester.fileparser;

import java.io.IOException;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 15:45
 */

public interface FileParser<T> {
    /**
     * 解析
     *
     * @param fileParseContext 上下文数据
     * @return 解析后的结果
     */
    T parse(FileParseContext<T> fileParseContext) throws IOException;
}
