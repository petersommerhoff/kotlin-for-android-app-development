import java.io.File
// -----------

val lines = File("rawdata.csv").bufferedReader().let {  // Scopes the buffered reader
  val result = it.readLines()  // Accesses reader as ‘it’
  it.close()
  result
}
