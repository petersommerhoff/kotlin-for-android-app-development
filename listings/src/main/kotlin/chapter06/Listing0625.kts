import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

runBlocking {
  val deferred: Deferred<Int> = async { throw Exception("Failed...") }

  try {
    deferred.await()  // Tries to get result of asynchronous call, throws exception
  } catch (e: Exception) {
    // Handle failure case here
    println("Exception was thrown")
  }
}
