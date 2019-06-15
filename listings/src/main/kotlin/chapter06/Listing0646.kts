val fibonacci = sequence {
  yield(1)
  var a = 0
  var b = 1
  while (true) {
    val next = a + b
    yield(next)
    a = b
    b = next
  }
}

fibonacci.take(10).forEach(::println)  // 1, 1, 2, 3, 5, 8, …
