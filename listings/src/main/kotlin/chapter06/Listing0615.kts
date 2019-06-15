import kotlinx.coroutines.runBlocking

annotation class Test
// ------------

fun main() = runBlocking<Unit> {  // Allows suspending calls in main
  updateWeather(42)
}

// In a test case…
@Test fun testUpdateWeather() = runBlocking { updateWeather(42) }
