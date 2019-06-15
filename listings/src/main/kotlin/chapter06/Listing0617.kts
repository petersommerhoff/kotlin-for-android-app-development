import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

runBlocking {  // runBlocking is required to call suspending ‘join’

  val job = launch {  // launch returns a Job object
    println("Coroutine started")
    delay(1000)
    println("Coroutine finished")
  }

  println("main() continues")
  job.join()  // Waits for completion of coroutine (non-blocking)
  println("main() finished")
}
