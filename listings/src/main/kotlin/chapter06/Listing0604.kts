import kotlinx.coroutines.experimental.launch

class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocation(user: User): Location = Location()
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather) {}
val userId = 1

launch {
// --------------
  val user = fetchUser(userId)  // Asynchronous call in sequential style
  val location = fetchLocation(user)
  val weatherData = fetchWeather(location)
  updateUi(weatherData)
}
