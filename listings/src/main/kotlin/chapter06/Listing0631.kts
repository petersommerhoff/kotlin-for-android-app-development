import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

GlobalScope.launch {
  launch(coroutineContext) {  // Launches child coroutine
    println("Running on ${Thread.currentThread().name}")
  }
}