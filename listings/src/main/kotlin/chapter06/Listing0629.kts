import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

GlobalScope.launch(newSingleThreadContext("My New Thread")) {  // Runs coroutine in new thread
  println("Running on ${Thread.currentThread().name}")
}