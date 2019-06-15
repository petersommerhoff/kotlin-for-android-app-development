import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking


runBlocking {

    // This actor keeps reading from its channel indefinitely
    val actor = actor<String> {
        for (value in channel) {
            println(value)
        }
    }

    actor.send("Hello")  // Makes actor print out Hello
    actor.send("World")  // Makes actor print out World
    actor.close()
}
