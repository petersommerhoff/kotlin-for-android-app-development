import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocation(user: User): Location = Location()
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather) {}
// --------------

suspend fun updateWeather(userId: Int) {
  val user = fetchUser(userId)
  val location = fetchLocation(user)
  val weatherData = fetchWeather(location)

  withContext(UI) {
    updateUi(weatherData)
  }
}

// Call-site
launch { updateWeather() }
