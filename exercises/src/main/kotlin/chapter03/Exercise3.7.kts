package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Usually, you would use the signature fun <T, R> Iterable<T>.map(f: (T) -> R) but this is covered in Chapter 4.

// Uses the abstract interface Iterable so that it works with all collections, ranges and more
fun Iterable<Int>.mapTo(transform: (Int) -> Int): List<Int> {
  val result = mutableListOf<Int>()
  for (element in this) {
    result.add(transform(element))
  }

  return result.toList()
}

// Simple test runs
val numbers = listOf(2, 7, 6, 11)
val mappedNumbers = numbers.mapTo { it * it }
println(mappedNumbers)

val range = 5..10
val mappedRange = range.mapTo { it + 5 }
println(mappedRange)