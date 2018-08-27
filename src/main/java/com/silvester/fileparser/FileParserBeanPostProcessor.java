package com.silvester.fileparser;

import com.silvester.fileparser.impl.FileParserFactoryImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-27 10:42
 */

public class FileParserBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof FileParser) {
            FileParserFactoryImpl.add((FileParser) bean);
        }
        return bean;
    }


}
