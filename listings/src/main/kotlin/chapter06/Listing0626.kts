import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Weather
fun updateUi(w: Weather) {}
val weatherData = Weather()
// ---------------

CoroutineScope(Dispatchers.Main).launch {  // Main dispatcher refers to UI context on Android
  updateUi(weatherData)
}
