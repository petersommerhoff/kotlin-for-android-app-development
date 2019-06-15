import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

runBlocking {
  val channel1 = Channel<Int>()
  val channel2 = Channel<Int>()

  launch {  // No need for the actor coroutine builder
    while (true) {
      select<Unit> {  // Provide any number of alternative data sources in here
        channel1.onReceive { println("From channel 1: $it") }
        channel2.onReceive { println("From channel 2: $it") }
      }
    }
  }

  channel1.send(17)  // Sends 17 to channel 1, thus this source is selected first
  channel2.send(42)  // Sends 42 to channel 2, causing channel 2 to be selected next
  channel1.close(); channel2.close()
}
