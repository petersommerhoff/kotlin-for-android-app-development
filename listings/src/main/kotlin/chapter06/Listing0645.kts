import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.future.await
import kotlinx.coroutines.future.future
import kotlinx.coroutines.runBlocking

suspend fun fetchValueAsync() = coroutineScope {
    future {
        delay(500)
        7
    }
}

runBlocking {
    fetchValueAsync().thenApply { it * 6 }
        .thenAccept { println("Retrieved value: $it") }
        .await()
}
