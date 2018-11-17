import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.channels.take

runBlocking {
  val producer = produce {
    var next = 1

    while (true) {
      send(next)
      next *= 2
    }
  }

  producer.take(10).consumeEach { println(it) }
}
