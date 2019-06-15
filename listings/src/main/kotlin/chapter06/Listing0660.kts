import kotlinx.coroutines.delay
import kotlinx.coroutines.future.future
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

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
