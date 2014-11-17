Redirect java.util.logging to SLF4J
=================

This bundle just calls the standard code to redirect calls to `java.util.logging.Logger` to the SLF4J system.

This bundle must be started before all other bundles which actually use `java.util.logging` in order to prevent
early log messages to be printed out already. In the current scenario, the bundle is started at start level 1, where
the rest is started with start level 4.
