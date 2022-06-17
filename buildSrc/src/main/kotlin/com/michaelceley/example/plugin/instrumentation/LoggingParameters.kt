package com.michaelceley.example.plugin.instrumentation

import com.android.build.api.instrumentation.InstrumentationParameters
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

interface LoggingParameters : InstrumentationParameters {
    @get:Input
    @get:Optional
    val forceInvalidate: Property<Long>
}