class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocation(user: User): Location = Location()
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather) {}
// --------------

suspend fun updateWeather(userId: Int) {
  try {
    val user = fetchUser(userId)
    val location = fetchLocation(user)
    val weatherData = fetchWeather(location)
    updateUi(weatherData)
  } catch(e: Exception) {
    // Handle exception
  } finally {
    // Cleanup
  }
}
