import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Weather
fun updateUi(w: Weather) {}
val weatherData = Weather()
// ---------------

GlobalScope.launch(Dispatchers.Main) {  // The UI context is provided by the coroutines-android dependency
  updateUi(weatherData)
}
