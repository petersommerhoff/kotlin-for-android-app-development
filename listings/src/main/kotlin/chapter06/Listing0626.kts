class Weather
fun updateUi(w: Weather) {}
val weatherData = Weather()
// ---------------

// Android-specific example (requires Android context)
//CoroutineScope(Dispatchers.Main).launch {  // Main dispatcher refers to UI context on Android
//  updateUi(weatherData)
//}
