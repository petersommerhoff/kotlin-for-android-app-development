package chapter02

import java.util.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Shuffles all chars in the given string
fun shuffle(str: String): String {
  val chars = str.toList()
  Collections.shuffle(chars)
  return chars.joinToString(separator = "")
}

/*
 * Shuffles only the inner characters of a string, meaning all but the first and last.
 *
 * Note: With generic functions (Chapter 4), you could write a much more general and thus reusable function
 * that shuffles a given range of some given Iterable<T>.
 */
fun shuffleInnerLetters(word: String): String {
  if (word.length <= 2) {
    return word
  }
  val innerLetters = word.substring(1, word.length - 1)
  val shuffledInner = shuffle(innerLetters)
  val firstLetter = word.first()
  val lastLetter = word.last()
  return "$firstLetter$shuffledInner$lastLetter"
}

// The list is certainly not complete
val punctuation = listOf('.', ',', ':', '-', '!', '?', ';')

fun memorizePunctuation(str: String): Map<Int, Char> {
  val indexToChar = mutableMapOf<Int, Char>()
  for ((index, char) in str.withIndex()) {
    if (char in punctuation) {
      indexToChar.put(index, char)
    }
  }
  return indexToChar
}

fun String.removePunctuation() = this.filterNot { it in punctuation }

fun shuffleSentence(sentence: String): String {
  val sentencePunctuation = memorizePunctuation(sentence)
  val words = sentence.removePunctuation().split(" ")
  val shuffledWords = mutableListOf<String>()
  for (word in words) {
    shuffledWords += shuffleInnerLetters(word)  // In Chapter 3, you'll learn how to do transformations like these more easily
  }

  val result = StringBuilder()
  result.append(shuffledWords.joinToString(separator = " "))
  for ((index, punc) in sentencePunctuation) {
    result.insert(index, punc)
  }
  return result.toString()
}

// Simple test run
println(shuffleSentence("You should still be able to read this without too much trouble. Especially once your brain gets used to this, you can read this almost like a normal sentence. This works well for simple texts but gets harder for sentences with more complicated words."))