
package com.rebuild.web;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author devezhao
 * @since 2020/11/3
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdParam {

    /**
     * Alias for {@link #name}.
     */
    @AliasFor("name")
    String value() default "id";

    /**
     * 参数名
     *
     * @return
     */
    @AliasFor("value")
    String name() default "id";

    /**
     * 是否必须
     *
     * @return
     */
    boolean required() default true;

}
