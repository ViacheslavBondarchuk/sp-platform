package hbv.com.ua.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingService {

    public void before(final JoinPoint joinPoint) {
        System.out.println();
    }

    public void after(final JoinPoint joinPoint) {
        System.out.println();
    }

    public void afterReturn(final JoinPoint joinPoint) {
        System.out.println();
    }

    public void afterThrowing(final JoinPoint joinPoint) {
        System.out.println();
    }
}
