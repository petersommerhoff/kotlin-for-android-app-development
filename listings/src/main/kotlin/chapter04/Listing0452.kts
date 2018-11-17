fun <T> Iterable<*>.filterByType(clazz: Class<T>): List<T?> {
  @Suppress("UNCHECKED_CAST")  // Must suppress unchecked cast
  return this.filter { clazz.isInstance(it) }.map { it as T? }  // Uses reflection
}

val elements = listOf(4, 5.6, "hello", 6, "hi", null, 1)
println(elements.filterByType(Int::class.javaObjectType))       // 4, 6, 1
