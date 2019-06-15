import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

CoroutineScope(newSingleThreadContext("My New Thread")).launch {  // Runs coroutine in new thread
  println("Running on ${Thread.currentThread().name}")
}