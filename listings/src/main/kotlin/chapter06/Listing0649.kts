import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking

runBlocking {

    val actor = actor<String> {
        val message = channel.receive()
        println(message)
    }

    actor.send("Hello World!")  // Sends an element to the actor’s channel
    actor.close()    // Closes channel because actor is no longer needed
}
