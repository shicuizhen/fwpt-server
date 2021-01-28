package com.sjzxy.fwpt.config.aop.log;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;





@Retention(RetentionPolicy.RUNTIME)
//Retention注解决定MyAnnotation注解的生命周期
@Target( { ElementType.METHOD, ElementType.TYPE })
//Target注解决定MyAnnotation注解可以加在哪些成分上，如加在类身上，或者属性身上，或者方法身上等成分
/*
 * @Retention(RetentionPolicy.SOURCE)
 * 这个注解的意思是让MyAnnotation注解只在java源文件中存在，编译成.class文件后注解就不存在了
 * @Retention(RetentionPolicy.CLASS)
 * 这个注解的意思是让MyAnnotation注解在java源文件(.java文件)中存在，编译成.class文件后注解也还存在，
 * 被MyAnnotation注解类标识的类被类加载器加载到内存中后MyAnnotation注解就不存在了
 */
/*
 * 这里是在注解类MyAnnotation上使用另一个注解类，这里的Retention称为元注解。
 * Retention注解括号中的"RetentionPolicy.RUNTIME"意思是让MyAnnotation这个注解的生命周期一直程序运行时都存在
 */
/**
 * 自定义日志注解类
 * 切入点为@SystemLog注解的类
 */
@Documented
public @interface ASystemLog {
    /**
     * 日志描述，这里使用了@AliasFor 别名
     *
     * @return String
     */
    @AliasFor("desc")
    String value() default "";

    /**
     * 日志描述
     *
     * @return String
     */
    @AliasFor("value")
    String desc() default "";
}
