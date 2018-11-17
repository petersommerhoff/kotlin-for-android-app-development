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
