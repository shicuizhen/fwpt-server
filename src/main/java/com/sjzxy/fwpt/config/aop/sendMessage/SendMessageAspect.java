package com.sjzxy.fwpt.config.aop.sendMessage;

import com.alibaba.fastjson.JSON;
import com.sjzxy.fwpt.config.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class SendMessageAspect {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 设置切入点：拦截被@ASystemLog注解的类
     */
    @Pointcut("@annotation(com.sjzxy.fwpt.config.aop.sendMessage.ASendMessage)")
    public void pointcut() {
    }

    /**
     * 切面方法,将参数信息发送到websocket中
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取签名，判断是否为方法注解
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("暂不支持非方法注解");
        }
        //获取执行的方法的参数
        Object[] objs = joinPoint.getArgs();

        //利用RequestContextHolder获取request对象,进而取得token,从token中获取当前用户
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        //调用controller中的实际方法
        Object result = joinPoint.proceed();
        //通过线程池执行日志保存
        Runnable runnable = () -> {
            System.out.println("通过websocket将数据发送给对应用户");
            try {
                WebSocketServer.sendInfo(objs[0].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        taskExecutor.execute(runnable);
        return result;
    }
}
