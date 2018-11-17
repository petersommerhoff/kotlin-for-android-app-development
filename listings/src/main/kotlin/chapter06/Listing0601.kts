class User
class Location
class Weather

fun fetchUser(id: Int, callback: (User) -> Unit) {}
fun fetchLocation(user: User, callback: (Location) -> Unit) {}
fun fetchWeather(location: Location, callback: (Weather) -> Unit) {}
fun updateUi(weather: Weather) {}
val userId = 1
// ------------

fetchUser(userId) { user ->
  fetchLocation(user) { location ->
    fetchWeather(location) { weatherData ->
      updateUi(weatherData)
    }
  }
}
