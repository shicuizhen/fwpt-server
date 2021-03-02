package com.sjzxy.fwpt.config.aop.sendMessage;

import com.alibaba.fastjson.JSON;
import com.sjzxy.fwpt.config.websocket.WebSocketServer;
import com.sjzxy.fwpt.entity.QuesComment;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.sql.Alias;
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
import java.util.HashMap;
import java.util.Map;

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

    @Resource
    WebSocketServer webSocketServer;

    /**
     * 切面方法,将参数信息发送到websocket中
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取签名，判断是否为方法注解
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("暂不支持非方法注解");
        }
        //取出注解ASendMessage的value值
        ASendMessage declaredAnnotation = signature.getMethod().getDeclaredAnnotation(ASendMessage.class);
        String value = declaredAnnotation.value();

        //获取执行的方法的参数
        Object[] objs = joinPoint.getArgs();
        System.out.println("objs:"+objs);
        System.out.println("objs[0]:"+objs[0]);
        //封装参数
        Map map = new HashMap();
        map.put("value",value);
        map.put("data",objs[0]);

        //利用RequestContextHolder获取request对象,进而取得token,从token中获取当前用户
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        //调用controller中的实际方法
        Object result = joinPoint.proceed();
        //通过线程池执行日志保存
        Runnable runnable = () -> {
            System.out.println("map.toString():"+JSON.toJSONString(map));
            webSocketServer.sendInfo( JSON.toJSONString(map));
        };
        taskExecutor.execute(runnable);
        return result;
    }
}
