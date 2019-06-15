import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

runBlocking {
  val parent = launch {
    repeat(10) { i ->
      launch {  // Implicitly uses coroutineContext, thus parent context
        delay(300L * (i + 1))
        println("Coroutine ${i + 1} finished")  // Only 1, 2, and 3 get to print
      }
    }
  }

  delay(1000)
  parent.cancelAndJoin()  // Cancels parent coroutine along with all its children
}
