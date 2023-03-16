package com.zkb.springredisstudy.dynamic.cglib.basedynamic;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
@AllArgsConstructor
public class LogAspect {

    @Around("@annotation(com.zkb.springredisstudy.dynamic.cglib.basedynamic.Log)")
    public Object logAop(ProceedingJoinPoint joinPoint) {
        System.out.println(joinPoint);
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println(ToStringBuilder.reflectionToString(obj));
        }
        try {
            Object proceed = joinPoint.proceed();
            System.out.println(proceed);
            ToStringBuilder.reflectionToString(proceed);
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
