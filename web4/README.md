Spring WebMVC
=================

This example is a simple Spring WebMVC example. Based on Spring 4.1.x.

Adding Spring
----------------

Spring still has not clue about OSGi. There was Spring DM (dynamic modules) for that, but it seems that development has stalled.
Also is there Eclipse Virgo, the Spring DM server.

You can build your own OSGi bundles from Spring, but I would not recommend that. You have OSGi anyway for using services.
OSGi has declarative services and blueprint for doing exactly what spring's application context does. Just in a real distributed way.

On the other hand Spring WebMVC is a pretty nice framework. And that what this sample is about!

Component Scan
----------------

Component scans don't work in OSGi, and probably a few other scenarious. So you have to discover
beans manually.

Commons Logging
-----------------

Spring uses Apache Commons Logging. The outer container uses "SLF4J JCL" in order to provide that dependency.
The beauty of OSGi ;-) As long as the classes are there, it just works!

This means that although Spring uses Commons Logging, all calls get forwarded to SLF4J and then to Logback. Not only
to a local instanceof inside the bundle, but to the global SLF4J instance. This way all bundles and modules will use the same
logging setup, no matter if they are implemented to use log4j, slf4j, JCL or JUL.
