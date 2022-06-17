package com.michaelceley.example.plugin.instrumentation

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

class LoggingClassVisitor(nextVisitor: ClassVisitor) : ClassVisitor(Opcodes.ASM9, nextVisitor) {

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        // Print the name of the class we're visiting.
        println(name)
        super.visit(version, access, name, signature, superName, interfaces)
    }

}