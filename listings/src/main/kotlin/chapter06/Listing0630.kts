import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

CoroutineScope(Dispatchers.Unconfined).launch {
  println("Running on ${Thread.currentThread().name}")
}