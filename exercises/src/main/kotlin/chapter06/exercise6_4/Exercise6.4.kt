package chapter06.exercise6_4

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel.Factory.RENDEZVOUS
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.selectUnbiased
import java.util.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * These exercise solutions use Kotlin 1.3 along with a newer coroutines version that uses structured concurrency -- a
 * fascinating concept that makes your concurrent code more predictable and easier to reason about. It's used since
 * version 0.26.0: https://github.com/Kotlin/kotlinx.coroutines/releases/tag/0.26.0
 *
 * Additionally, the syntax change a little. Read about the changes here:
 * 1) Structured concurrency: https://medium.com/@elizarov/structured-concurrency-722d765aa952
 * 2) Kotlin 1.3: https://kotlinlang.org/docs/reference/whatsnew13.html
 */

suspend fun doPeriodically(periodInMs: Int, task: suspend () -> Unit) {
  while (true) {
    task()
    delay(periodInMs.toLong())
  }
}

// With structured concurrency, this is the common pattern to create actors (via extension function on CoroutineScope)
fun CoroutineScope.produceRandomNumbers(periodInMs: Int = 0): ReceiveChannel<String> = produce(capacity = RENDEZVOUS) {
  doPeriodically(periodInMs) {
    send("$periodInMs ms: ${Random().nextInt(100) + 1}")
  }
}

// Since Kotlin 1.3, the parameter for the main function is optional
fun main() = runBlocking<Unit> {

  val producer300ms = produceRandomNumbers(periodInMs = 300)
  val producer500ms = produceRandomNumbers(periodInMs = 500)
  val producer1000ms = produceRandomNumbers(periodInMs = 1000)

  actor<Nothing>(capacity = RENDEZVOUS) {
    doPeriodically(periodInMs = 200) {
      selectUnbiased<Unit> {  // Unbiased (fair) select that chooses randomly between available sources
        producer300ms.onReceive { println(it) }
        producer500ms.onReceive { println(it) }
        producer1000ms.onReceive { println(it) }
      }
    }
  }

  delay(5000)
  System.exit(0)
}
