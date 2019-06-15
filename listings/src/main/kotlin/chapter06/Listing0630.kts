import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

GlobalScope.launch(Dispatchers.Unconfined) {
  println("Running on ${Thread.currentThread().name}")
}