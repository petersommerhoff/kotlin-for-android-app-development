class Foo {
  fun plainMethod() {}
  infix fun with(other: Any) = Pair(this, other)
  inline fun inlined(i: Int, operation: (Int, Int) -> Int) = operation(i, 42)
  operator fun Int.times(str: String) = str.repeat(this)
  fun withDefaults(n: Int = 1, str: String = "Hello World") = n * str
}

val obj = Foo()
obj.plainMethod()
val pair = obj with "Kotlin"
val foo = obj.inlined(3, { i, j -> i * j })  // 126
obj.withDefaults(str = "Hello Kotlin")          // "Hello Kotlin"
with(obj) { 2 * "hi" }                          // Uses 'with' to access extension

// -----------
println(foo)
println(obj.withDefaults(str = "Hello Kotlin"))