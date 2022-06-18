package com.michaelceley.example.plugin.instrumentation

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class LoggingMethodVisitor(private val methodSignature: String?,
                           methodVisitor: MethodVisitor)
    : MethodVisitor(Opcodes.ASM9, methodVisitor) {

    override fun visitCode() {
        // Print the name of the method that we're visiting.
        println(" - Visiting method: $methodSignature")

        when (methodSignature) {
            "onClick(Landroid/view/View;)V" -> {

                // Load the variable in locals slot 1.
                // Locals:
                //  - 0: this
                //  - 1: First parameter (View)
                visitVarInsn(Opcodes.ALOAD, 1)

                // Inject the printViewDetails call into click listeners.
                // Must load the View onto the operand stack (prior command) before
                // injecting this method which will consume the loaded variable.
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printViewDetails",
                    "(Landroid/view/View;)V",
                    false
                )
            }
            "onCheckedChanged(Landroid/widget/CompoundButton;Z)V" -> {

                // Load the variables in locals slot 1 and slot 2
                // Locals:
                //  - 0: this
                //  - 1: First parameter (CompoundButton)
                //  - 2: Second parameter (Boolean)
                visitVarInsn(Opcodes.ALOAD, 1)
                visitVarInsn(Opcodes.ILOAD, 2)

                // Inject the printValueChangeDetails call into the checked changed
                // listeners. Must load the parameters, in order, onto the operand stack
                // before injecting this method which will consume both of the loaded
                // values matching the method signature.
                // NOTE: Z in the descriptor represents the boolean value, but it's loaded
                // from the locals pool as an integer.
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printValueChangeDetails",
                    "(Landroid/widget/CompoundButton;Z)V",
                    false
                )
            }
            "onContentChanged()V" -> {

                // Inject the printContentChangedMessage call into the window callback.
                // Nothing to load prior to this call since the injected method
                // takes no parameters and consumes nothing from the stack.
                visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "com/michaelceley/examples/library/Logger",
                    "printContentChangedMessage",
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