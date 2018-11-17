import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout

runBlocking {
  try {
    withTimeout(1200) {
      repeat(10) {
        delay(500)
        println("${it + 1} of 10")
      }
    }
  } catch (e: TimeoutCancellationException) {
    println("Time is up!")
  } finally {
    println("Cleaning up open connections...")
  }
}