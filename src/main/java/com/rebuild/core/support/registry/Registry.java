
package com.rebuild.core.support.registry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对 RB 进行二次开发时可以通过此注解进行新功能的注册
 *
 * @author devezhao
 * @since 2020/9/4
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Registry {
}
