package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// 1)
val sentence = "Why are iPhone chargers not called apple juice?"
val words = sentence.split(" ")
var index = 0
while (index < words.size) {
  print("${words[index]}. ")
  index++
}

// 2)
val steps = 55..100 step 5
index = 0  // Don't usually reuse the same index in another loop!
while (true) {
  val gradeBoundary = steps.elementAtOrNull(index) ?: break
  println("Next grade: ${gradeBoundary - 5} - ${gradeBoundary}")
  index++
}

// 3)
/*
 * This one cannot be expressed as a for loop in Kotlin.
 *
 * In contrast to languages like C++ and Java, while and for loops in Kotlin are not fundamentally
 * equivalent -- while loops are more expressive. More specifically, for loops in Kotlin are
 * equivalent to for-each loops from other languages and only allow iterating over anything that
 * provides an iterator().
 */
