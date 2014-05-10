package by.experiments.aspectj.aspect;

import by.experiments.aspectj.exception.ServiceException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/**
 * Aspect that prints into console some method results.
 *
 * @author Tsimafei_Shchytkavets
 */
@Aspect
public class SimpleLoggerAspect
{
    private Set<WeakReference<ServiceException>> thrownExceptions = new HashSet<WeakReference<ServiceException>>();

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
        for (WeakReference<ServiceException> thrownException : thrownExceptions)
        {
            if (exception.equals(thrownException.get()))
            {
                return;
            }
        }
        System.out.println("Exception: " + exception);
        thrownExceptions.add(new WeakReference<ServiceException>(exception));
    }
}
