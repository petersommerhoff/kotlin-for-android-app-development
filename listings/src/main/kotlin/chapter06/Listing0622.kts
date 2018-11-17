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

runBlocking {

  // Asynchronous composition: total runtime ~1s
  val first = fetchFirstAsync()    // Inferred type: Deferred<Int>
  val second = fetchSecondAsync()  // Inferred type: Deferred<Int>
  val result = first.await() / second.await()  // Awaits completion; now type is Int
  println("Result: $result")       // 42
}
