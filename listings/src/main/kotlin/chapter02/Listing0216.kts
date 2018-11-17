fun fib(n: Int): Long {
  return if (n < 2) {
    1
  } else {
    fib(n - 1) + fib(n - 2)
  }
}

val fib = fib(7)    // 21L

println(fib)
