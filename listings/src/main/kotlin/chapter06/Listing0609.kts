suspend fun updateWeather() {}
// -----------

fun wrapper() {
  // Error: Suspend function must be called from coroutine or other suspend function
//  updateWeather()
}