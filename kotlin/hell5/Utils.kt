package hell5

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
fun readInputAsFile(name: String) = File("src/main", "$name.txt")

fun readInputAsList(name: String) = File("src/main", "$name.txt").readLines()

fun readInputAsString(name: String) = Files.readString(Path.of("src/main/$name.txt"))