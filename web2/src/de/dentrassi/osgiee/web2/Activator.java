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
package de.dentrassi.osgiee.web2;

 import java.io.IOException;
 import java.io.Writer;
 import java.util.Map;

 import org.osgi.framework.BundleActivator;
 import org.osgi.framework.BundleContext;
 import org.osgi.framework.ServiceReference;
 import org.osgi.util.tracker.ServiceTracker;

 import de.dentrassi.osgiee.service1.Service;

 public class Activator implements BundleActivator
 {
     private static Activator INSTANCE;

     private ServiceTracker<Service, Service> tracker;

     @Override
     public void start ( final BundleContext context ) throws Exception
     {
         this.tracker = new ServiceTracker<Service, Service> ( context, Service.class, null );
         this.tracker.open ();

         INSTANCE = this;
     }

     @Override
     public void stop ( final BundleContext context ) throws Exception
     {
         INSTANCE = null;

         this.tracker.close ();
     }

     public static void sayHello ( final Writer writer ) throws IOException
     {
         writer.write ( "<ul>" );
         for ( final Map.Entry<ServiceReference<Service>, Service> entry : INSTANCE.tracker.getTracked ().entrySet () )
         {
             writer.write ( "<li>" );
             writer.write ( entry.getValue ().getHello () );
             writer.write ( "<ul>" );
             for ( final String key : entry.getKey ().getPropertyKeys () )
             {
                 writer.write ( String.format ( "<li>%s = %s</li>", key, entry.getKey ().getProperty ( key ) ) );
             }
             writer.write ( "</ul>" );
             writer.write ( "</li>" );
         }
         writer.write ( "</ul>" );
     }
 }
