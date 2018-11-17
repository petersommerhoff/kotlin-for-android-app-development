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
// -----------------

abstract class Issue(var priority: Int) {
  abstract fun complete()               // Abstract method
  open fun trivial() { priority = 15 }  // Open method
  fun escalate() { priority = 100 }     // Closed method
}

class Task(val title: String, priority: Int) : Issue(priority), Archivable {
  // … -------
  override var archiveWithTimeStamp: Boolean = true
  override fun archive() {}
  // ---------
  override fun complete() { println("Completed task: $title") } // Required override
  override fun trivial() { priority = 20 }                      // Optional override
  // Cannot override ‘escalate’ because it is closed
}
