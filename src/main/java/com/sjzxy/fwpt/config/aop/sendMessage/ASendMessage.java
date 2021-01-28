package com.sjzxy.fwpt.config.aop.sendMessage;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//Retention注解决定MyAnnotation注解的生命周期
@Target( { ElementType.METHOD, ElementType.TYPE })
@Documented
public @interface ASendMessage {
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
