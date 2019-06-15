import kotlinx.coroutines.runBlocking

runBlocking {
  // Can call suspending functions inside runBlocking
  updateWeather(42)
}
