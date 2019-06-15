import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.runBlocking

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
