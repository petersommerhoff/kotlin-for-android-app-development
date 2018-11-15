package chapter02

import kotlin.math.sqrt

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Inefficient solution that suffices for amicable pairs of numbers up to 2000
fun findAmicablePairs(upperBound: Int): List<Pair<Int, Int>> {
  val amicablePairs = mutableListOf<Pair<Int, Int>>()
  for (n in 1..upperBound) {
    val sumDivisorsOfN = properDivisors(n).sum()
    for (m in n+1..upperBound) {
      val sumDivisorsOfM = properDivisors(m).sum()
      if (sumDivisorsOfN == m && sumDivisorsOfM == n) amicablePairs.add(n to m)
    }
  }
  return amicablePairs
}

private fun properDivisors(n: Int): List<Int> {
  if (n == 0) return emptyList()

  val properDivisors = mutableListOf(1)  // 1 is always a proper divisor

  // It suffices to iterate to sqrt(n) and then add n/j to the divisors (if n/j != j)
  for (j in 2..sqrt(n.toDouble()).toInt()) {
    if (n % j == 0) {
      properDivisors.add(j)
      if (n/j != j) {
        properDivisors.add(n/j)
      }
    }
  }
  return properDivisors
}

// More efficient solution that can find amicable pairs of numbers up to 100,000 quickly and takes only a few seconds
// for an upper bound of 1,000,000
fun findAmicablePairsFast(upperBound: Int): List<Pair<Int, Int>> {
  val amicablePairs = mutableListOf<Pair<Int, Int>>()
  val sumsOfDivisors = IntArray(upperBound + 1) { properDivisors(it).sum() }  // Cache the sums of divisors
  for (n in 1..upperBound) {
    val m = sumsOfDivisors[n]
    if (m < upperBound && m > n && sumsOfDivisors[m] == n) {
      amicablePairs.add(n to m)
    }
  }
  return amicablePairs
}

fun main(args: Array<String>) {
  println(findAmicablePairs(2000))
  println(findAmicablePairsFast(1_000_000))
}