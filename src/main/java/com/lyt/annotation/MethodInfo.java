package com.lyt.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Administrator
 * 注解方法不能有参数
 * 注解方法的返回类型局限于原始类型，字符串，枚举，注解，或以上类型构成的数组
 * 注解方法可以包含默认值
 * 注解可以包含预期绑定的元注解，元注解为注解提供信息，有四种元注解类型
 * @Documented @Target @Inherited @Retention
 * 表姐的博客：http://blog.csdn.net/lovesomnus/article/details/46468785
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Somnus";
    String date();
    int revision() default 1;
    String comments();
}
