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
package de.dentrassi.osgiee.web5.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;
import org.osgi.util.tracker.ServiceTracker;

import de.dentrassi.osgiee.service2.BookService;
import de.dentrassi.osgiee.web5.JdbcDriverInformation;

public class Activator implements BundleActivator
{
    private static Activator INSTANCE;

    private ServiceTracker<BookService, BookService> tracker;

    private BundleContext context;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;
        this.tracker = new ServiceTracker<BookService, BookService> ( context, BookService.class, null );
        this.tracker.open ();
        INSTANCE = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.context = null;
        this.tracker.close ();
        INSTANCE = null;
    }

    public static BookService getBookService ()
    {
        return INSTANCE.tracker.getService ();
    }

    public static BookService waitForBookService ( final long timeout )
    {
        try
        {
            return INSTANCE.tracker.waitForService ( timeout );
        }
        catch ( final InterruptedException e )
        {
            return null;
        }
    }

    public static List<JdbcDriverInformation> getJdbcDrivers ()
    {
        final List<JdbcDriverInformation> result = new ArrayList<> ();

        try
        {
            final Collection<ServiceReference<DataSourceFactory>> refs = INSTANCE.context.getServiceReferences ( DataSourceFactory.class, null );
            for ( final ServiceReference<DataSourceFactory> ref : refs )
            {
                final String className = getString ( ref.getProperty ( "osgi.jdbc.driver.class" ) );
                String name = getString ( ref.getProperty ( "osgi.jdbc.driver.name" ) );
                final String version = getString ( ref.getProperty ( "osgi.jdbc.driver.version" ) );

                if ( className == null )
                {
                    continue;
                }

                if ( name == null )
                {
                    name = className;
                }

                result.add ( new JdbcDriverInformation ( className, name, version ) );
            }
        }
        catch ( final InvalidSyntaxException e )
        {
        }

        Collections.sort ( result, new Comparator<JdbcDriverInformation> () {

            @Override
            public int compare ( final JdbcDriverInformation o1, final JdbcDriverInformation o2 )
            {
                return o1.getName ().compareTo ( o2.getName () );
            }
        } );

        return result;
    }

    private static String getString ( final Object value )
    {
        if ( value instanceof String )
        {
            return (String)value;
        }
        return null;
    }
}
