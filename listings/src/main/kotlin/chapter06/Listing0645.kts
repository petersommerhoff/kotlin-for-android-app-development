import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.future.await
import kotlinx.coroutines.experimental.future.future
import kotlinx.coroutines.experimental.runBlocking

fun fetchValueAsync() = future {
  delay(500)
  7
}

runBlocking {
  fetchValueAsync().thenApply { it * 6 }
      .thenAccept { println("Retrieved value: $it") }
      .await()
}
