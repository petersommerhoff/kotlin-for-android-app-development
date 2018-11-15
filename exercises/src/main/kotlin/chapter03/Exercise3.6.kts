package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun generateLookAndSaySequence(initial: Int): Sequence<String> {
  // This is an alternative to validation as done in Exercise 3.5
  require(initial in 1..9) { "Sequence must start with a positive integer" }

  return generateSequence(initial.toString()) {
    val NONE = '-'
    val chars = it.toCharArray()
    val output = StringBuilder()

    var currentNumber = NONE
    var counter = 0

    for (char in chars) {
      if (char == currentNumber) {
        counter++
      } else {
        if (currentNumber != NONE) output.append("$counter$currentNumber")
        currentNumber = char
        counter = 1
      }
    }
    output.append("$counter$currentNumber")
    output.toString()
  }
}

// Simple test run
val lookAndSay = generateLookAndSaySequence(1)
lookAndSay.take(10).forEach(::println)

println()

val lookAndSayWith9 = generateLookAndSaySequence(9)  // Sequence elements always end with "19"
lookAndSayWith9.take(10).forEach(::println)

/*
 * Super bonus: with initial value in 1..3, the sequence can never contains a 4.
 *
 * This can easily be proved by contradiction:
 * - Let's assume there was an element in the sequence with a 4.
 * - Without loss of generality, we can assume that the 4 is followed by a 1 in that element.
 * - Thus, the sequence element containing "41" signifies that its predecessor contained the substring "1111".
 * - But this contradicts the structure of the sequence because the substring "1111" would have been "21" instead
 *   ("one one followed by one one are two ones).
 * - Thus, the original element containing 4 cannot exist.
 */