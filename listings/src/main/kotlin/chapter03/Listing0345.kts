import java.io.File
// ----------

val lines = File("rawdata.csv").bufferedReader().use { it.readLines() }