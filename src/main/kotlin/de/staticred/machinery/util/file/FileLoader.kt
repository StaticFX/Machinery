package de.staticred.machinery.util.file

import org.json.JSONObject
import java.io.File
import java.nio.file.Files

object FileLoader {

    val BASE_DIR = File(System.getProperty("home.dir") + "/.machinery")
    val SAVE_DIR = File(BASE_DIR.absolutePath + "/saves")

    private fun createFileIfNotExists(name: String, directory: Directory) {
        val file = File(directory.directory.absoluteFile, name)

        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.createNewFile()
        }
    }

    fun loadFile(name: String, directory: Directory): JSONObject {
        createFileIfNotExists(name, directory)
        val file = File(directory.directory.absoluteFile, name)

        val lines = file.readText()
        return JSONObject(lines)
    }
}