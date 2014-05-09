package by.experiments.aspectj.service;

import by.experiments.aspectj.annotation.Measured;

/**
 * Simple service implementation.
 *
 * @author Tsimafei_Shchytkavets
 */
public class TestAspectJServiceImpl
{
    private ProblematicServiceImpl problematicService = new ProblematicServiceImpl();

    public void simpleTestMethod()
    {
        System.out.println("Inside simpleTestMethod");
    }

    @Measured
    public void simpleAnnotatedTestMethod()
    {
        System.out.println("Inside simpleAnnotatedTestMethod");
    }

    public Long returnId()
    {
        return 123L;
    }

    public void saveData()
    {
        problematicService.saveData();
    }
}
