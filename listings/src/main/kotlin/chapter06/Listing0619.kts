import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

runBlocking {

  val job = launch {
    repeat(10) {
      delay(300)                     // Cooperative delay from stdlib
      println("${it + 1} of 10...")  // Only 1 of 10, 2 of 10, 3 of 10 are printed
    }
  }

  delay(1000)
  println("main(): No more time")
  job.cancel()  // Can control cancellation on per-coroutine level
  job.join()    // Then wait for it to cancel
  println("main(): Now ready to quit")
}
