import java.io.Serializable

interface Archivable {
  var archiveWithTimeStamp: Boolean  // Abstract property
  val maxArchiveSize: Long           // Property with default impl., thus must be val
    get() = -1                       // Default implementation returns -1
  fun archive()                      // Abstract method
  fun print() {                      // Open method with default implementation
    val withOrWithout = if (archiveWithTimeStamp) "with" else "without"
    val max = if (maxArchiveSize == -1L) "∞" else "$maxArchiveSize"
    println("Archiving up to $max entries $withOrWithout time stamp")
  }
}

class Task(title: String, priority: Int) : Archivable, Serializable {  // Implements multiple interfaces
  override var archiveWithTimeStamp = true
  override fun archive() { }
}
// -----------------

val n: Number = 3                              // Integer is a subclass of Number
val todo: Archivable = Task("Write book", 99)  // Task is a subclass of Archivable
