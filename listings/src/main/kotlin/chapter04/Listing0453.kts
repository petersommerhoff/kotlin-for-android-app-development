inline fun <reified T> Iterable<*>.filterByType(): List<T?> {  // Inline+reified
  return this.filter { it is T }.map { it as T? }  // No reflection used, can use ‘is’
}

val elements = listOf(4, 5.6, "hello", 6, "hi", null, 1)
println(elements.filterByType<Int>())              // 4, 6, 1
