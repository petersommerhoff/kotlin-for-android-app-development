import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

runBlocking {
  val actor = actor<String>(capacity = Channel.CONFLATED) {  // Conflated channel
    for (value in channel) { println(value) }
  }

  actor.send("Hello")  // Will be overwritten by following element
  actor.send("World")  // Overwrites Hello if it was not yet consumed by the actor
  delay(500)
  actor.close()
}
