import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

runBlocking {
  val job = launch(start = CoroutineStart.LAZY) {  // Runs only when triggered
    println("Lazy coroutine started")
  }

  println("Moving on...")
  delay(1000)
  println("Still no coroutine started")
  job.join()  // Triggers execution of the coroutine using join()
  println("Joined coroutine")
}
