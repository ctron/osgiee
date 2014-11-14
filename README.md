OSGi EE
=========

Recipes for modular EE applications based on OSGi

* [jetty-9.2.x](jetty-9.2.x/README.md) - Setup a target platform using Jetty 9.2.5 with JSP support
* web1 - sample web project with Eclipse WTP and jetty

Starting
-----------

First you need to create the target platform:
* Be sure that you do not have already opened the target platform editor for `jetty.target`
* Run the `build.ant` script in the `jetty-9.2.x` folder. This will download the necessary binaries
* Open the file `jetty.target` and use "Set as Target Platform" (upper right corner) to activate the target platform.

Starting "web1"
------------------

* Right click on the file `Jetty9.2.x.launch` and select "Run as" -> "Jetty9.2.x"
* Direct your web browser to http://localhost:8080/web1 (jsp) and http://localhost:8080/web1/test (servlet)
