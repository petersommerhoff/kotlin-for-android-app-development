package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * To generate these rational numbers, we cannot simply start going through 1, 2, 3, 4, ... because
 * we would never "arrive" at any non-integer numbers. A similar statement goes for any sequence
 * where only the denominator increases first.
 *
 * The idea is to generate the sequence of elements 1, 1/2, 2, 1/3, 2/3, 3, 1/4, 2/4, 3/4, 4, ...
 *
 * You can visualize this in an infinite triangle where we go through the bottom-left to top-right
 * diagonals:
 *
 * 1   2   3   4   5
 * 1/2 2/3 3/4 4/5
 * 1/3 2/4 3/5
 * 1/4 2/5
 * 1/5
 *
 * This ensures that every rational numbers leq 1 is theoretically generated at some point.
 */



fun generateRationals(): Sequence<Double> {
  var denominator = 1
  var numerator = 1
  return sequence {
    while (true) {
      if (numerator == denominator) {  // Switches to next diagonal
        yield(denominator++.toDouble())  // Yields denominator and increments it for next iteration via ++
        numerator = 1
      } else {  // Iterates through current diagonal
        yield(numerator++.toDouble() / denominator)  // Increments numerator for next iteration via ++
      }
    }
  }
}

// Simple test run
val rationals = generateRationals()
rationals.take(20).forEach(::println)