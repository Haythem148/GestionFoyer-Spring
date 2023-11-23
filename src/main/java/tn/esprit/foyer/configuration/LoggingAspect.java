package tn.esprit.foyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.foyer.Service.*.add*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Before method " + name + " : ");
    }
@After("execution(* tn.esprit.foyer.Service.*.*(..))")
    public void exitMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("After method " + name + " : ");
    }
    @AfterReturning("execution(* tn.esprit.foyer.Service.*.*(..))")
    public void afterReturningMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after returning method " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.foyer.Service.*.*(..))")
    public void afterThrowingMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after throwing method " + name + " : ");
    }
}