import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout

runBlocking {
  withTimeout(1200) {
    repeat(10) {
      delay(500)
      println("${it + 1} of 10")
    }
  }
}
