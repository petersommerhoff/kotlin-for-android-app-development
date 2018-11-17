import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class Weather
fun updateUi(w: Weather) {}
val weatherData = Weather()
// ---------------

launch(UI) {  // The UI context is provided by the coroutines-android dependency
  updateUi(weatherData)
}
