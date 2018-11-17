class Person(val name: String)
// -----------

fun printAll(array: Array<*>) {  // Nothing known about type of array, but type-safe
  array.forEach(::println)
}

printAll(arrayOf(1, 2, 3))
printAll(arrayOf("a", 2.7, Person("Sandy")))  // Can pass in arrays of arbitrary type
