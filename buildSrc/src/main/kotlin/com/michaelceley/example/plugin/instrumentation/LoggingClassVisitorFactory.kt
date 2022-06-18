package com.michaelceley.example.plugin.instrumentation

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import org.objectweb.asm.ClassVisitor

abstract class LoggingClassVisitorFactory : AsmClassVisitorFactory<LoggingParameters> {

    companion object {
        // These are the only three types we care about instrumenting in this example.
        private const val checkChangeListener = "android.widget.CompoundButton\$OnCheckedChangeListener"
        private const val clickListener = "android.view.View\$OnClickListener"
        private const val windowCallback = "android.view.Window\$Callback"

        private val interfacesOfNote by lazy {
            listOf(
                checkChangeListener,
                clickListener,
                windowCallback
            )
        }
    }

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return LoggingClassVisitor(nextClassVisitor)
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        // Only instrument classes that implement an interface we care about.
        return classData.interfaces.any { it in interfacesOfNote }
    }
}