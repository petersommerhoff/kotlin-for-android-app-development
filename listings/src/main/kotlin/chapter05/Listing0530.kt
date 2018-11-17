@file:JvmName("Nothing")

package chapter05

fun fail(message: String): Nothing {          // Indicates non-terminating function
  throw AssertionError(message)
}

fun takeNothing(perpetualMotion: Nothing) {}  // Impossible to call from Kotlin