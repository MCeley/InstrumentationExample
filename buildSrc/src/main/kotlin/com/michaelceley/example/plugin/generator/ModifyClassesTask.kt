package com.michaelceley.example.plugin.generator

import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFiles
import org.gradle.api.tasks.TaskAction
import javassist.ClassPool
import org.gradle.api.file.FileSystemLocationProperty
import org.gradle.api.file.RegularFile


abstract class ModifyClassesTask: DefaultTask() {

    @get:InputFiles
    abstract val allClasses: ListProperty<Directory>

    @get:OutputFiles
    abstract val output: DirectoryProperty

    @TaskAction
    fun taskAction() {
        val pool = ClassPool(ClassPool.getDefault())

        for(i in 0..20000) {
            val generatedClass = pool.makeClass("com.example.testing.Listener$i")
            generatedClass.writeFile(output.get().asFile.absolutePath)
        }
    }
}