package com.bastex.codelearninghub.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class MathServiceAspect {
    @Around("execution(int com.bastex.codelearninghub.spring.aop.service.MathService.add(int, int))")
    public Object monitorAdd(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Method start {}", proceedingJoinPoint.getSignature());
        final Instant start = Instant.now();
        final Object proceed = proceedingJoinPoint.proceed();
        log.info("Method executed {}. Execution time: {} milliseconds", proceedingJoinPoint.getSignature(), Duration.between(start, Instant.now()).toMillis());
        return proceed;
    }

    @AfterReturning(value = "execution(int com.bastex.codelearninghub.spring.aop.service.MathService.subtract(int, int))", returning = "result")
    public void monitorAfterReturningSubtract(final JoinPoint joinPoint, final int result) {
        log.info("Result of subtract method: {}", result);
    }

    /**
     * Here * at the beginning fo execution defines many return types and ".." defines many arguments types.
     * It could be used to intercept if there are more than one overloaded methods of the same name.
     */
    @AfterThrowing(pointcut = "execution(* com.bastex.codelearninghub.spring.aop.service.MathService.add(..))", throwing = "e")
    public void afterThrowingAdd(final JoinPoint jp, final Exception e) {
        log.error("Exception thrown in add method. Class: {}, kind: {}, signature: {}, target: {}", jp.getClass(), jp.getKind(), jp.getSignature(), jp.getTarget(), e);
    }

    /**
     * JointPoint can be injected if needed
     **/
    @Before("execution(int com.bastex.codelearninghub.spring.aop.service.MathService.subtract*(..))")
    public void monitorBeforeSubtract(final JoinPoint jp) {
        log.info("Before subtract is called {}", jp.getSignature());
    }

    @After("execution(int com.bastex.codelearninghub.spring.aop.service.MathService.subtract*(..))")
    public void monitorAfterSubtract() {
        log.info("After subtract is called");
    }

    /**
     * Example of using pointcuts
     */
    @After("multiplyPointCut() || multiplyChainPointCut()")
    public void monitorMultiply(final JoinPoint joinPoint) {
        log.info("After multiply method is called in: {}", joinPoint.getSignature());
    }

    /**
     * Pointcut: A predicate that matches join points
     */
    @Pointcut("execution(int com.bastex.codelearninghub.spring.aop.service.MathService.multiply(int, int))")
    public void multiplyPointCut() {
    }

    @Pointcut("execution(int com.bastex.codelearninghub.spring.aop.service.MathService.multiplyChain(int, int, int...))")
    public void multiplyChainPointCut() {
    }
}
