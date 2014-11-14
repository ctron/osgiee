JSP with JSTL
==================

An example with JSP and JSTL.

Code completion for tag libs
-------------

In order to have code completion in Eclipse, you need to place the "tld" files manually in your bundle and add a corresponding `web.xml`.

This seems to be required since the lookup mechanism of Eclipse WTP does not look for tag libs in the while classpath (which could include
the plugin classpath). Otherwise the whole `WEB-INF` folder of this plugin could be removed. Also the dependency to package
`org.apache.taglibs.standard.tag.rt.core` was only added to satisfy the code validator.

Bug 451529 - jstl not found
-------------

According to the Jetty documentation there is nothing special required for using JSTL. However there seems to be a bug in
`jetty-osgi-boot-js` which checks for a wrong class name. See also [bug #451529](https://bugs.eclipse.org/bugs/show_bug.cgi?id=451529).

But there is a workaround which originally is for specifing bundles which provide other tag libs (beside JSTL). However you can
also specify the JSTL implementation bundle and it works. For this the
system property `org.eclipse.jetty.osgi.tldbundles` must be set to `org.apache.taglibs.standard-impl`

```
-Dorg.eclipse.jetty.osgi.tldbundles=org.apache.taglibs.standard-impl
```
