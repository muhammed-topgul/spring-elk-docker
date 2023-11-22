package com.mtopgul.customerservice.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 10:39
 */
@Aspect
@Component
@Log4j2
public class LoggingAspect {
    @Pointcut("within(com.mtopgul..*) && !execution(* com.mtopgul.customerservice.excepti̇on.GlobalExceptionHandler.*(..))")
    public void packagePointcut() {
    }

    private String getParameters(Object[] args) {
        if (args.length > 0) {
            String argsStr = Arrays.toString(args);
            return argsStr.substring(1, argsStr.length() - 1);
        }
        return "";
    }

    @AfterThrowing(pointcut = "packagePointcut()", throwing = "throwable")
    public void logAfterException(JoinPoint joinPoint, Throwable throwable) {
        Signature signature = joinPoint.getSignature();
        log.error("> Exception in {}.{}({}) with cause = {}.",
                signature.getDeclaringTypeName(),
                signature.getName(),
                getParameters(joinPoint.getArgs()),
                Objects.requireNonNullElse(throwable.getMessage(), "NULL"));
    }

    @Around("packagePointcut()")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        log.info("> Request: {}.{}({}).",
                signature.getDeclaringTypeName(),
                signature.getName(),
                getParameters(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.info("> Invocation result: {}.{}({}) with result = {}.",
                signature.getDeclaringTypeName(),
                signature.getName(),
                getParameters(joinPoint.getArgs()),
                result);
        return result;
    }
}
