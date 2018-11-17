fun reducePressureBy(bar: Int) {
  // …
  throw IllegalArgumentException("Invalid pressure reduction by $bar")
}

try {
  reducePressureBy(30)
} catch (e: IllegalArgumentException) {
  // Handle exception here
} catch (e: IllegalStateException) {
  // You can handle multiple possible exceptions
} finally {
  // This code will always execute at the end of the block
}
