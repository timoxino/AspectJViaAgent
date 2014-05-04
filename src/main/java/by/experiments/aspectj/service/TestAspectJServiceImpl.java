package by.experiments.aspectj.service;

import by.experiments.aspectj.annotation.Measured;

/**
 * Simple service implementation.
 *
 * @author Tsimafei_Shchytkavets
 */
public class TestAspectJServiceImpl
{
    public void simpleTestMethod()
    {
        System.out.println("Inside simpleTestMethod");
    }

    @Measured
    public void simpleAnnotatedTestMethod()
    {
        System.out.println("Inside simpleAnnotatedTestMethod");
    }
}
