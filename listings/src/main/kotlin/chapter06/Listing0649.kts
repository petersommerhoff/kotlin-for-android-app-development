import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.runBlocking

val actor = actor<String> {
  val message = channel.receive()
  println(message)
}

runBlocking {
  actor.send("Hello World!")  // Sends an element to the actor’s channel
  actor.close()    // Closes channel because actor is no longer needed
}
