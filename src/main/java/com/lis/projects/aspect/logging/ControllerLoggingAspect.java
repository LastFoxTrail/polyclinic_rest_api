package com.lis.projects.aspect.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLoggingAspect {
    private final static Logger CONTROLLER_LOGGER = Logger
            .getLogger(ControllerLoggingAspect.class);

    @AfterThrowing(
            pointcut = "execution(* com.lis.projects.controller.*.*(..))",
            throwing = "exception"
    )
    public void AfterThrowingNewException(JoinPoint joinPoint, Throwable exception) {

        CONTROLLER_LOGGER.error("IN Class: "
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"\nMethod name: "+ joinPoint.getSignature().getName()
                +"\nException message: "+ exception.getMessage()
                +"\n----------------------------------"
        );
    }
}
