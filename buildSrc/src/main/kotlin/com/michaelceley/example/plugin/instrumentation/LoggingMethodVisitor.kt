package com.michaelceley.example.plugin.instrumentation

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class LoggingMethodVisitor(private val methodName: String?,
                           methodVisitor: MethodVisitor)
    : MethodVisitor(Opcodes.ASM9, methodVisitor) {

    override fun visitCode() {
        println(" - Visiting method: $methodName")
        
        when (methodName) {
            "onClick" -> {
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printClickMessage",
                    "()V",
                    false
                )
            }
            "onCheckedChanged" -> {
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