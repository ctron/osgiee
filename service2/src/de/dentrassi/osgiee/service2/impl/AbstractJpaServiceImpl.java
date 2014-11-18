package de.dentrassi.osgiee.service2.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AbstractJpaServiceImpl
{
    private EntityManagerFactory entityManagerFactory;

    public static interface ManagerFunction<T>
    {
        public T process ( EntityManager entityManager );
    }

    public void setEntityManagerFactory ( final EntityManagerFactory entityManagerFactory )
    {
        this.entityManagerFactory = entityManagerFactory;
    }

    protected <T> T doWithManager ( final ManagerFunction<T> function )
    {
        final EntityManager em = this.entityManagerFactory.createEntityManager ();
        try
        {
            return function.process ( em );
        }
        finally
        {
            em.close ();
        }
    }

}
