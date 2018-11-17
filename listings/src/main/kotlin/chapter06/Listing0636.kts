import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

runBlocking {
  val parent = launch {
    repeat(10) { i ->
      launch {  // Implicitly uses coroutineContext, thus parent context
        delay(300 * (i + 1))
        println("Coroutine ${i + 1} finished")  // Only 1, 2, and 3 get to print
      }
    }
  }

  delay(1000)
  parent.cancelAndJoin()  // Cancels parent coroutine along with all its children
}
