suspend fun updateWeather() {}
// -----------

fun main(args: Array<String>) {
  // Error: Suspend function must be called from coroutine or other suspend function
//  updateWeather()
}