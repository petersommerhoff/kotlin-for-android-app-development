class User
class Location
class Weather
suspend fun fetchUser(id: Int): User = User()
suspend fun fetchLocations(user: User): List<Location> = listOf(Location(), Location())
suspend fun fetchWeather(location: Location): Weather = Weather()
fun updateUi(weather: Weather, location: Location) {}
// --------------

suspend fun updateWeather(userId: Int) {
  val user = fetchUser(userId)
  val locations = fetchLocations(user)
  for (location in locations) {
    val weatherData = fetchWeather(location)
    updateUi(weatherData, location)
  }
}
