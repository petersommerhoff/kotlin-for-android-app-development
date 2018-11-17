package chapter05

inline fun require(predicate: Boolean, message: () -> String) {
  if (!predicate) println(message())
}

fun main(args: Array<String>) {  // Listing uses main function to show decompiled code
  require(someCondition()) { "someCondition must be true" }
}

// -------
fun someCondition() = false
