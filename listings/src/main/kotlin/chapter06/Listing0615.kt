import kotlinx.coroutines.experimental.runBlocking

annotation class Test
// ------------

fun main(args: Array<String>) = runBlocking<Unit> {  // Allows suspending calls in main
  updateWeather()
}

// In a test case…
@Test fun testUpdateWeather() = runBlocking { updateWeather() }
