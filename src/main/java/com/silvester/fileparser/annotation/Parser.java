package com.silvester.fileparser.annotation;


import com.silvester.fileparser.Default;
import com.silvester.fileparser.FileType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author lvpanfeng
 * @version 1.0
 * @since 2018-08-24 17:50
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Parser {
    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     *
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

    /**
     * group info
     *
     * @return
     */
    Class group() default Default.class;

    /**
     * support files
     *
     * @return
     */
    FileType[] support();
}
