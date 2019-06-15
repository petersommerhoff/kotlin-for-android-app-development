import kotlinx.coroutines.*

runBlocking {
  val job = launch {
    repeat(10) {
      if (isActive) {  // Cooperative
        Thread.sleep(300)
        println("${it + 1} of 10...")
      }
    }
  }

  delay(1000)
  job.cancelAndJoin()
}
