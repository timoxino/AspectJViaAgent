package by.experiments.aspectj.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect that prints into console some method results.
 *
 * @author Tsimafei_Shchytkavets
 */
@Aspect
public class SimpleLoggerAspect
{
    @Pointcut("execution(Long *(..))")
    public void returnId()
    {
    }

    @AfterReturning(pointcut = "returnId()", returning = "id")
    public void printId(Long id)
    {
        System.out.println("Returned id: " + id);
    }
}
