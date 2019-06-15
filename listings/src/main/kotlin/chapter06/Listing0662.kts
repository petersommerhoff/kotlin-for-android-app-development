import kotlinx.coroutines.delay

suspend fun otherSuspend() {}
// ----------

suspend fun suspending(): Int {
  delay(1000)     // Suspension point #1
  val a = 17
  otherSuspend()  // Suspension point #2
  println(a)

  return 0
}
