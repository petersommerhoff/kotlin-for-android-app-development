import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newSingleThreadContext

launch(newSingleThreadContext("My New Thread")) {  // Runs coroutine in new thread
  println("Running on ${Thread.currentThread().name}")
}