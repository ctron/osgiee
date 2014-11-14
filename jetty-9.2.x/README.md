Jetty 9.2.5
==============

Based on the Jetty documentation for OSGi [1]

Important
------------

* Be sure not to have whitespaces in your launch path, Jetty can't handle that
* Start 'org.eclipse.jetty.osgi.boot' after all other bundles have started

Software base
----------------

The main sources of binaries are

* Jetty 9.2.5 distribution jar
* Eclipse Equinox "Mars" Milestone M3
* Eclipse Orbit R20140525021250
* Some links to maven central

Additional stuff
------------------

 * I added slf4j and logback from Eclipse Orbit for logging

Documentation issues
----------------------

The documentation of Jetty with OSGi [1] has some issues.

* Instead of `org.glassfish.web:javax.servlet.jsp.jstl-1.2.2.jar` and `org.eclipse.jetty.orbit:javax.servlet.jsp.jstl-1.2.0.v201105211821.jar` form the `lib/jsp` folder, you have to use the files from `apache-jstl`
* I had to add the following dependencies in addition
 - javax.activation 1.1 - from [Eclipse Orbit](http://download.eclipse.org/tools/orbit/downloads/drops/R20140525021250/repository/plugins/javax.activation_1.1.0.v201211130549.jar)
 - org.apache.xalan 2.7.1 - from [Eclipse Orbit](http://download.eclipse.org/tools/orbit/downloads/drops/R20140525021250/repository/plugins/org.apache.xalan_2.7.1.v201005080400.jar)
 - org.apache.xml.serializer 2.7.1 - from [Eclipse Orbit](http://download.eclipse.org/tools/orbit/downloads/drops/R20140525021250/repository/plugins/org.apache.xml.serializer_2.7.1.v201005080400.jar)

[1] https://www.eclipse.org/jetty/documentation/current/framework-jetty-osgi.html
