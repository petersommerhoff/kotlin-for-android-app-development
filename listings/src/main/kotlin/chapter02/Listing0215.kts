fun fib(n: Int): Long {
  return if (n < 2) {
    1
  } else {
    fib(n - 1) + fib(n - 2)
  }
}

print(fib(7))