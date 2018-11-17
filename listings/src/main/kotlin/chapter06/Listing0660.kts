import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.future.future
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.suspendCancellableCoroutine
import java.util.concurrent.CompletableFuture

suspend fun <T> CompletableFuture<T>.myAwait(): T {
  return suspendCancellableCoroutine { continuation ->
    whenComplete { value, exception ->
      if (exception == null) continuation.resume(value)
      else continuation.resumeWithException(exception)
    }
  }
}

runBlocking {
  val completable = future { delay(1000); 42 }
  println(completable.myAwait())  // 42

  val fail = future<Int> { throw Exception("Could not fetch value") }
  println(fail.myAwait())         // Throws exception
}
