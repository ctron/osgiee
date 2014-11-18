/*******************************************************************************
 * Copyright (c) 2014 Jens Reimann.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.osgiee.service2.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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

    protected <T> T doWithTransaction ( final ManagerFunction<T> function )
    {
        return doWithManager ( new ManagerFunction<T> () {
            @Override
            public T process ( final EntityManager entityManager )
            {
                final EntityTransaction tx = entityManager.getTransaction ();

                tx.begin ();

                try
                {
                    final T result = function.process ( entityManager );
                    tx.commit ();
                    return result;
                }
                catch ( final Exception e )
                {
                    if ( tx.isActive () )
                    {
                        tx.rollback ();
                    }
                    throw new RuntimeException ( e );
                }
            }
        } );
    }
}
