package com.smartzhe.controller.jifenpay.aspect;

import com.smartzhe.controller.jifenpay.request.BaseRequest;
import com.smartzhe.controller.jifenpay.request.PageRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/31
 * Time: 16:42  .
 */
@Aspect
@Order(10)
@Component
public class AspectController {


    @Around("execution(* com.smartzhe.controller.jifenpay.*Controller.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object[] objects = proceedingJoinPoint.getArgs();
            for (Object obj : objects) {
                if (obj instanceof BaseRequest) {
                    //验证处理
                    ((BaseRequest) obj).validate();
                }
            }
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throw throwable;
        }finally {
            long endTime = System.currentTimeMillis();
            //记录日志一个方法调用花费的时间
            System.out.println("around==>" + proceedingJoinPoint.getSignature().getName()+"耗时："+(endTime-startTime)+"ms");

        }
    }
}
