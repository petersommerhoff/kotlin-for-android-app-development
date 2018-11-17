abstract class Issue(var priority: Int) {
  abstract fun complete()               // Abstract method
  open fun trivial() { priority = 15 }  // Open method
  fun escalate() { priority = 100 }     // Closed method
}

class Task(val title: String, priority: Int) : Issue(priority) {
  override fun complete() { println("Completed task: $title") } // Required override
  override fun trivial() { priority = 20 }                      // Optional override
  // Cannot override ‘escalate’ because it is closed
}
// ------------

interface Function<in T, out R> {  // Contravariant w.r.t. T and covariant w.r.t. R
  fun apply(t: T): R
}

object IssueToInt : Function<Issue, Int> {
  override fun apply(t: Issue) = t.priority
}

// Star projections
val f1: Function<*, Int>  = IssueToInt  // apply() not callable but would return Int
val f2: Function<Task, *> = IssueToInt  // apply() callable, returns Any?
val f3: Function<*, *>    = IssueToInt  // apply() not callable and would return Any?

val errand = Task("Save the world", 80)
val urgency: Any? = f2.apply(errand)
