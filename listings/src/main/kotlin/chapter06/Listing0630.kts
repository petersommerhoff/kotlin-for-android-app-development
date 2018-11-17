import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.launch

launch(Unconfined) {
  println("Running on ${Thread.currentThread().name}")
}