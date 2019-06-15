import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

runBlocking {
  withTimeout(1200) {
    repeat(10) {
      delay(500)
      println("${it + 1} of 10")
    }
  }
}
