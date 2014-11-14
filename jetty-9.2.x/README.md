Jetty 9.2.5
==============

Based on the Jetty documentation for OSGi [1]

* Be sure not to have whitespaces in your launch path, Jetty can't handle that
* Start 'org.eclipse.jetty.osgi.boot' after all other bundles have started

[1] https://www.eclipse.org/jetty/documentation/current/framework-jetty-osgi.html
