import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.take
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

runBlocking {
  val channel = Channel<String>()
  repeat(3) { n ->
    launch {
      while (true) {
        channel.send("Message from actor $n")
      }
    }
  }

  channel.take(10).consumeEach { println(it) }
  channel.close()
}
