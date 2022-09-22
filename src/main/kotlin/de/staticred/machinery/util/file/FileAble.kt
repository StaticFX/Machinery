package de.staticred.machinery.util.file

interface FileAble {

    val title: String

    fun toFile(): String
    fun fromFile(content: String)

    fun update(): String

}