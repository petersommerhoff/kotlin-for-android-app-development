import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.runBlocking

// This actor keeps reading from its channel indefinitely
val actor = actor<String> {
  for (value in channel) { println(value) }
}

runBlocking {
  actor.send("Hello")  // Makes actor print out Hello
  actor.send("World")  // Makes actor print out World
  actor.close()
}
