import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun fetchFirstAsync() = GlobalScope.async {  // Return type is Deferred<Int>
  delay(1000)
  294  // Return value of lambda, type Int
}

fun fetchSecondAsync() = GlobalScope.async {  // Return type is Deferred<Int>
  delay(1000)
  7  // Return value of lambda, type Int
}
// ------------------

runBlocking {

  // Effectively synchronous: total runtime ~2s
  val first = fetchFirstAsync().await()    // Inferred type: Int (runtime ~1s)
  val second = fetchSecondAsync().await()  // Inferred type: Int (runtime ~1s)
}
