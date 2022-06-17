package com.michaelceley.example.plugin

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import com.michaelceley.example.plugin.instrumentation.LoggingClassVisitorFactory
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class InstrumentationPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)

        androidComponents.onVariants { variant ->
            variant.instrumentation.transformClassesWith(
                LoggingClassVisitorFactory::class.java,
                InstrumentationScope.PROJECT) {
                // Pass in the current system time on every evaluation.
                // This forces the plugin to run all of its code every time.
                // This should be removed in a real plugin to enable incremental builds.
                it.forceInvalidate.set(System.currentTimeMillis())
            }
            variant.instrumentation.setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES)
        }
    }
}