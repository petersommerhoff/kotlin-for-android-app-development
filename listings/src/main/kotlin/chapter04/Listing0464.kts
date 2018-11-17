interface Compare<in T> {       // ‘in’ indicates contravariance
  fun compare(a: T, b: T): Int  // T is only used at in-position
}

abstract class Issue(var priority: Int) {
  abstract fun complete()               // Abstract method
  open fun trivial() { priority = 15 }  // Open method
  fun escalate() { priority = 100 }     // Closed method
}
class Task(val title: String, priority: Int) : Issue(priority) {
  override fun complete() { println("Completed task: $title") } // Required override
}
// -----------

val taskComparator: Compare<Task> = object : Compare<Issue> {  // Uses contravariance
  override fun compare(a: Issue, b: Issue) = a.priority - b.priority
}
