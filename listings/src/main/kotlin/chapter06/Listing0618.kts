import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

runBlocking {

  // Launch 100,000 coroutines
  val jobs = List(100_000) {
    launch {
      delay(1000)
      print("+")
    }
  }
  jobs.forEach { it.join() }
}
