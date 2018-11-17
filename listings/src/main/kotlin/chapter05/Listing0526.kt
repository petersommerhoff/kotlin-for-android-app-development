@file:JvmName("CsvUtils")
package chapter05

import java.io.File
import java.io.FileNotFoundException

@Throws(FileNotFoundException::class)  // Generates throws-clause in bytecode
fun readInput() = File("input.csv").readText()

