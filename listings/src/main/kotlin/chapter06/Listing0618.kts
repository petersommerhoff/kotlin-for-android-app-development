import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
