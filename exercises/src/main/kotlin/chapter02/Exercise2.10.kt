package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

import kotlin.collections.*

fun anagramsOfSubstrings(str: String): Int {
  var anagramCount = 0
  val lengthToSubstrings = getSubstringsByLength(str)
  for (substrings in lengthToSubstrings.values) {
    for ((i, s1) in substrings.withIndex()) {
      for (s2 in substrings.elementsAfter(i)) {
        if (s1.isAnagramOf(s2)) anagramCount++
      }
    }
  }
  return anagramCount
}

private fun getSubstringsByLength(str: String): Map<Int, List<String>> {
  val lengthToSubstrings = mutableMapOf<Int, List<String>>()
  for (length in 1..(str.length - 1)) {
    lengthToSubstrings[length] = str.windowed(size = length, step = 1)
  }

  return lengthToSubstrings
}

private fun <T> List<T>.elementsAfter(index: Int) = this.subList(index + 1, this.size)

private fun String.isAnagramOf(other: String): Boolean = (letterFrequencies(this) == letterFrequencies(other))

private fun letterFrequencies(str: String): Map<Char, Int> =
    str.toCharArray().groupBy { it }.map { it.key to it.value.size }.toMap()

fun main(args: Array<String>) {
  println(anagramsOfSubstrings("abba"))    // 4
  println(anagramsOfSubstrings("abcd"))    // 0
  println(anagramsOfSubstrings("kkkk"))    // 10
  println(anagramsOfSubstrings("abab"))    // 5
  println(anagramsOfSubstrings("peter"))   // 2
  println(anagramsOfSubstrings("heyyy"))   // 4
  println(anagramsOfSubstrings("heyyyy"))  // 10
}
