data class Weather(val temperature: Int)
fun fetchWeatherOrNull() = Weather(23)
fun updateUi(degrees: Int) { println("$degrees°C") }
// ----------

val weather: Weather? = fetchWeatherOrNull()

weather?.let {
  updateUi(weather.temperature)  // Only updates UI if ‘weather’ is not null
}
