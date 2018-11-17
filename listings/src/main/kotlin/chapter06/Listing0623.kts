import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun fetchFirstAsync() = async {  // Return type is Deferred<Int>
  delay(1000)
  294  // Return value of lambda, type Int
}

fun fetchSecondAsync() = async {  // Return type is Deferred<Int>
  delay(1000)
  7  // Return value of lambda, type Int
}
// ------------------

runBlocking {

  // Effectively synchronous: total runtime ~2s
  val first = fetchFirstAsync().await()    // Inferred type: Int (runtime ~1s)
  val second = fetchSecondAsync().await()  // Inferred type: Int (runtime ~1s)
}
