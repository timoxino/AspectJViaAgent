package by.experiments.aspectj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect that measure method execution time.
 *
 * @author Tsimafei_Shchytkavets
 */
@Aspect
public class TimerAspect
{
    @Pointcut("execution(* *(..))")
    public void any()
    {
    }

    @Pointcut("execution(@by.experiments.aspectj.annotation.Measured * *(..))")
    public void annotated()
    {
    }

    @After("any()")
    public void printAnyMethodName(JoinPoint joinPoint)
    {
        System.out.println("Method name is " + joinPoint.getSignature().getName());
    }

    @Around("annotated()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        final long before = System.nanoTime();
        final Object result = proceedingJoinPoint.proceed();
        final long after = System.nanoTime();
        System.out.println("Method " + proceedingJoinPoint.getSignature().getName() + " execution time: "
                + (after - before));
        return result;
    }
}
