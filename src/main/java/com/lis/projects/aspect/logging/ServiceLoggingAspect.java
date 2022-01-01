package com.lis.projects.aspect.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLoggingAspect {
    private static final Logger SERVICE_LOGGER = Logger
            .getLogger(ServiceLoggingAspect.class);

    @AfterReturning("execution(* com.lis.projects.service.impl.*.getAll*())")
    public void AfterGetDataCollection(JoinPoint joinPoint) {

        SERVICE_LOGGER.info("IN Class: "
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"\nMethod name: "+ joinPoint.getSignature().getName()
                +"\nResult: data received successfully"
                +"\n----------------------------------"
        );
    }

    @AfterReturning("execution(* com.lis.projects.service.impl.*.getById(Long))")
    public void AfterGetObjectById(JoinPoint joinPoint) {

        SERVICE_LOGGER.info("IN Class: "
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"\nMethod name: "+ joinPoint.getSignature().getName()
                +"\nResult: object with id: "+ joinPoint.getArgs()[0]
                +" received successfully"
                +"\n----------------------------------"
        );
    }

    @AfterReturning("execution(* com.lis.projects.service.impl.*.save(*))")
    public void AfterSaveObject(JoinPoint joinPoint) {

        SERVICE_LOGGER.info("IN Class: "
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"\nMethod name: "+ joinPoint.getSignature().getName()
                +"\nResult: object- "+ joinPoint.getArgs()[0]
                +" saved successfully"
                +"\n----------------------------------"
        );
    }

    @AfterReturning("execution(* com.lis.projects.service.impl.*.deleteById(Long))")
    public void AfterDeleteObjectById(JoinPoint joinPoint) {

        SERVICE_LOGGER.info("IN Class: "
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                +"\nMethod name: "+ joinPoint.getSignature().getName()
                +"\nResult: object with id: "+ joinPoint.getArgs()[0]
                +" deleted successfully"
                +"\n----------------------------------"
        );
    }
}
