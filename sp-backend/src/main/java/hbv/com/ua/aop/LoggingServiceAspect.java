package hbv.com.ua.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

@Slf4j
public class LoggingServiceAspect {

    public void before(final JoinPoint joinPoint) {
        log.info("Before call: class: {} method: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    public void after(final JoinPoint joinPoint) {
        log.info("After call: class: {} method: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    public void afterReturn(final JoinPoint joinPoint) {
        log.info("After return call: class: {} method: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    public void afterThrowing(final JoinPoint joinPoint) {
        log.info("After throw call: class: {} method: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }
}
