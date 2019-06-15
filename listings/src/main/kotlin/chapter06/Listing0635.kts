import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

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