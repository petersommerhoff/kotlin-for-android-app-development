class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocation(user: User): Location = Location()
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather) {}
val userId = 1
// --------------

suspend fun updateWeather() {
  val user = fetchUser(userId)              // Suspension point #1
  val location = fetchLocation(user)        // Suspension point #2
  val weatherData = fetchWeather(location)  // Suspension point #3
  updateUi(weatherData)
}
