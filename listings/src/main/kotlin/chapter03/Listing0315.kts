fun contains(range: IntRange, number: Int): Boolean {
  range.forEach {
    if (it == number) return true  // Can use return because lambda is inlined
  }
  return false
}
