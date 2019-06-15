import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

runBlocking {
  val job = launch {
    repeat(10) {
      Thread.sleep(300)        // Non-cooperative
      println("${it + 1} of 10...")  // All ten iterations are executed
    }
  }

  delay(1000)
  job.cancelAndJoin()  // Cancel is ignored, will wait for another two seconds
}
