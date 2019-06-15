import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

GlobalScope.launch {
  launch(coroutineContext) {
    println("Running on ${Thread.currentThread().name}")
  }
}