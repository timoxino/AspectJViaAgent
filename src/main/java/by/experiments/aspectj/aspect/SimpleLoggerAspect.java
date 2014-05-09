package by.experiments.aspectj.aspect;

import by.experiments.aspectj.exception.ServiceException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @Pointcut("execution(* save*(..))")
    public void anySave()
    {
    }

    @AfterReturning(pointcut = "returnId()", returning = "id")
    public void printId(Long id)
    {
        System.out.println("Returned id: " + id);
    }

    @AfterThrowing(pointcut = "anySave()", throwing = "exception")
    public void printException(ServiceException exception)
    {
        System.out.println("Exception: " + exception);
    }
}
