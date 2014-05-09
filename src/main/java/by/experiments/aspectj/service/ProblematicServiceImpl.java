package by.experiments.aspectj.service;

import by.experiments.aspectj.exception.ServiceException;

/**
 * Simple service implementation that throws exception.
 *
 * @author Tsimafei_Shchytkavets
 */
public class ProblematicServiceImpl
{
    public void saveData()
    {
        throw new ServiceException();
    }
}
