fun contains(range: IntRange, number: Int): Boolean {
  for (element in range) {
    if (element == number) return true  // This return is equivalent to the one above
  }
  return false
}
