import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

runBlocking {
  val deferred: Deferred<Int> = async { throw Exception("Failed...") }

  try {
    deferred.await()  // Tries to get result of asynchronous call, throws exception
  } catch (e: Exception) {
    // Handle failure case here
    println("Exception was thrown")
  }
}
