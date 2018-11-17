val authorsToBooks = mutableMapOf("Joshua Bloch" to listOf("Effective Java"))
// -------------

val authors = authorsToBooks.apply {
  putIfAbsent("Martin Fowler", listOf("Patterns of Enterprise Application Architecture"))
}.filter {
  it.value.isNotEmpty()
}.also {
  println("Authors with books: ${it.keys}")
}.map {
  it.key
}
