package by.experiments.aspectj;

import by.experiments.aspectj.service.TestAspectJServiceImpl;

/**
 * Entry point of aspectj testing application.
 *
 * @author Tsimafei_Shchytkavets
 */
public class Runner
{
    public static void main(String[] args)
    {
        final TestAspectJServiceImpl service = new TestAspectJServiceImpl();
        service.simpleTestMethod();
        service.simpleAnnotatedTestMethod();
        service.returnId();
    }
}
