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

runBlocking {

  // Asynchronous composition: total runtime ~1s
  val first = fetchFirstAsync()    // Inferred type: Deferred<Int>
  val second = fetchSecondAsync()  // Inferred type: Deferred<Int>
  val result = first.await() / second.await()  // Awaits completion; now type is Int
  println("Result: $result")       // 42
}
