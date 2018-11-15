package chapter03


/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun Int.isEven() = this % 2 == 0

fun generateHailstoneSequence(initial: Int) =
    if (initial <= 0)
      throw IllegalArgumentException("Sequence must start with a positive integer")
    else generateSequence(initial) { n ->
      if (n == 1) return@generateSequence null  // Makes the sequence terminate
      if (n.isEven()) n / 2 else 3 * n + 1  // Defines value of next element via lambda return value
    }

fun buildHailstoneSequence(initial: Int) =
    if (initial <= 0)
      throw IllegalArgumentException("Sequence must start with a positive integer")
    else sequence {
      // Use `sequence` instead in Kotlin 1.3
      var next = initial
      while (true) {
        yield(next)
        if (next == 1) return@sequence
        next = if (next.isEven()) next / 2 else 3 * next + 1
      }
    }

// Simple test runs for `generateSequence`
val hailstoneOfSeven = generateHailstoneSequence(7)
val hailstoneOf1337 = generateHailstoneSequence(1337)

hailstoneOfSeven.forEach { print("$it, ") }
println()
hailstoneOf1337.forEach { print("$it, ") }

println("\n")

// Simple test runs for `buildSequence`
val builtHailstoneOfSeven = buildHailstoneSequence(7)
val builtHailstoneOf1337 = buildHailstoneSequence(1337)

builtHailstoneOfSeven.forEach { print("$it, ") }
println()
builtHailstoneOf1337.forEach { print("$it, ") }