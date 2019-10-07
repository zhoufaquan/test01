
package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Logs;
import com.example.demo.service.LogsService;
import com.example.demo.util.HttpClientUtils;
import com.example.demo.util.IpUtils;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private LogsService logsService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.example.demo.aop.SystemControllerLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        Logs sysLog = new Logs();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        SystemControllerLog myLog = method.getAnnotation(SystemControllerLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setLogOperation(value);
        }

        //获取请求的类名和函数名
        String className = joinPoint.getTarget().getClass().getName();
        className = className.substring(17);
        String methodName = method.getName();
        sysLog.setLogMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();

        sysLog.setLogParm(forJsonString(args));


        sysLog.setLogTime(new Date());
        //获取用户名
        //获取用户ip地址

        HttpServletRequest request = HttpClientUtils.getHttpServletRequest();
        sysLog.setLogUser(String.valueOf(request.getSession().getAttribute("USERNAME")));
        sysLog.setLogIp(IpUtils.getIpAddr(request));

        logsService.insert(sysLog);
    }

    public String forJsonString(Object[] args) {
        Object[] res = new Object[args.length];
        int j = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                continue;
            } else {
                res[j] = args[i];
                j++;
            }
        }
        String ret = null;
        if (res != null) {
            ret = JSON.toJSONString(res);
        }
        return ret;
    }

}


