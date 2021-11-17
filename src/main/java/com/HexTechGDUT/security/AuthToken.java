package com.HexTechGDUT.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限;
 * 带有该注解表示http请求必须带有token
 * @author HexTechGDUT
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthToken {
    boolean required() default true;
    //区分token权限的时候使用，目前暂时没有作用
    String value() default "";
}
