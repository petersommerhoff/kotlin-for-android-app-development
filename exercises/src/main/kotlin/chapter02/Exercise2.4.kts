package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * 1) You want to check if a user’s age is in the range 1 to 10, 11 to 20, …, 41 to 50, or above.
 *
 * Here, a when expression without argument allows for the most concise and readable solution:
 */
val age = 42
when {
  age < 1 -> throw IllegalArgumentException("Value must be at least 1")
  age in 1..10 -> println("1 to 10")
  age in 11..20 -> println("11 to 20")
  age in 21..30 -> println("21 to 30")
  age in 31..40 -> println("31 to 40")
  age in 41..50 -> println("41 to 50")
  else -> println("Over 50")
}

/*
 * 2) You want to execute a certain piece of code if a variable is not null.
 *
 * This is a common use case for a simple if statement:
 */
val response = "200 OK"
if (response != null) {
  println("Received response: $response")
}

/*
 * 3) You want to compare a given variable against each value from a finite set of distinct values,
 * such as a set of several different states an automaton may be in.
 *
 * This is a prime example for using when statements:
 *
 * (Enums are covered later in Chapter 4 and improve representing states like the following)
 */
val states = arrayOf("IDLE", "RUNNING", "COMPLETED")
val currentState = "RUNNING"

when (currentState) {
  "IDLE" -> println("Process is idle")
  "RUNNING" -> println("Process is running")
  "COMPLETED" -> println("Process has completed")
}

/*
 * 4) While processing a tree data structure, you want to switch between two different paths of
 * execution depending on whether you’re at an inner branch or a leaf of the tree.
 *
 * Although you could do this with a when statement, choosing between two paths is a perfect use
 * case for a simple if-else statement:
 */
val isLeaf = false
if (isLeaf) {
  println("Reached a leaf, will go back up the tree...")
} else {
  println("At an inner node, will continue descending until a leaf is reached...")
}