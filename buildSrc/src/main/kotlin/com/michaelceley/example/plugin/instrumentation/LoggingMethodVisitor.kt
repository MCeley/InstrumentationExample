package com.michaelceley.example.plugin.instrumentation

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class LoggingMethodVisitor(private val methodName: String?,
                           methodVisitor: MethodVisitor)
    : MethodVisitor(Opcodes.ASM9, methodVisitor) {

    override fun visitCode() {
        // Print the name of the method that we're visiting.
        println(" - Visiting method: $methodName")

        when (methodName) {
            "onClick" -> {
                // Inject the printClickMessage call into click listeners.
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printClickMessage",
                    "()V",
                    false
                )
            }
            "onCheckedChanged" -> {
                // Inject the printValueChangeMessage call into checked listeners.
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printValueChangeMessage",
                    "()V",
                    false
                )
            }
            else -> {
                super.visitCode()
            }
        }
    }
}