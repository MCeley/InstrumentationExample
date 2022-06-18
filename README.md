# Instrumentation Example

Starting in version 8.0, Google is [removing the Transform API](https://developer.android.com/studio/releases/gradle-plugin-api-updates#transform-removed) from the Android Gradle Plugin. Since [the example that Google maintains](https://developer.android.com/studio/releases/gradle-plugin-api-updates#transform-removed) is out of date and takes some fixing up in order to get running, I wanted to create a simple, bare bones example of how to use `transformClassesWith` as part of the AGP Instrumentation API.

This project shows how to do the following:
 * Create a library module that has some logging functionality.
 * Create an Android app that includes that library module.
 * Create a Gradle plugin using the `buildSrc` directory.
 * Inject logging calls from the library module into the Android app using the AGP Instrumentation API.
 * Inject logging calls that consume parameters from the locals pool.