import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

suspend fun fetchFirst(): Int {
  delay(1000)
  return 294
}

suspend fun fetchSecond(): Int {
  delay(1000)
  return 7
}

runBlocking {
  val a = async { fetchFirst() }   // Asynchrony is explicit
  val b = async { fetchSecond() }  // Asynchrony is explicit

  println("Result: ${a.await() / b.await()}")
}
