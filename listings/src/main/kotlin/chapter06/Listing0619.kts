import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

runBlocking {

  val job = launch {
    repeat(10) {
      delay(300)                     // Cooperative delay from stdlib
      println("${it + 1} of 10...")  // Only 1 of 10, 2 of 10, 3 of 10 are printed
    }
  }

  delay(1000)
  println("runBlocking: No more time")
  job.cancel()  // Can control cancellation on per-coroutine level
  job.join()    // Then wait for it to cancel
  println("runBlocking: Now ready to quit")
}
