package com.sjzxy.fwpt.config.aop.log;

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
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;
import com.alibaba.fastjson.JSON;

/**
 * 日志切面类
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    @Autowired
    private SystemLogService logService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 设置切入点：拦截被@ASystemLog注解的类
     */
    @Pointcut("@annotation(com.sjzxy.fwpt.config.aop.log.ASystemLog)")
    public void pointcut() {
    }

    /**
     * 切面方法,记录日志
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //创建日志实体，用于封装日志信息
        SystemLog systemLog = new SystemLog();

        //获取签名，判断是否为方法注解
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("暂不支持非方法注解");
        }

        //获取执行的方法
        MethodSignature methodSign = (MethodSignature) signature;
        Method method = methodSign.getMethod();
        ASystemLog logAnno = AnnotationUtils.getAnnotation(method, ASystemLog.class);
        //获取访问目标的方法名
        String methodName = joinPoint.getSignature().getName();

        //利用RequestContextHolder获取request对象,进而取得token,从token中获取当前用户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        String token = request.getHeader("Authorization");
//        String user = JWTUtil.getUsername(token);

        //日志信息存入数据库
//        log.setOperator(user);
        systemLog.setOperator("user");
        systemLog.setOperateMethod(methodName);
        systemLog.setOperateParams(JSON.toJSONString(request.getParameterMap()));
        systemLog.setOperateDesc(logAnno.desc());
        systemLog.setIp(GetIpAddressUtil.getIpAddress(request));
        Object result = null;
        try {
            //调用实际方法
            result = joinPoint.proceed();
            systemLog.setOperateResult("正常");
        } catch (SQLException e) {
            systemLog.setOperateResult("失败");
        } finally {
            //添加日期
            systemLog.setOperateDate(new Date());
            //通过线程池执行日志保存
            Runnable runnable = () -> {
                logService.save(systemLog);
            };
            taskExecutor.execute(runnable);
        }
        return result;
    }
}
