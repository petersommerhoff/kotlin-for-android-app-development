import java.util.concurrent.CompletableFuture

class User
class Location
class Weather

fun fetchUser(id: Int): CompletableFuture<User> = CompletableFuture()
fun fetchLocation(user: User): CompletableFuture<Location> = CompletableFuture()
fun fetchWeather(location: Location): CompletableFuture<Weather> = CompletableFuture()
fun updateUi(weather: Weather) {}
val userId = 1
// ----------

fetchUser(userId)
    .thenCompose { user -> fetchLocation(user) }
    .thenCompose { location -> fetchWeather(location) }
    .thenAccept { weatherData -> updateUi(weatherData) }
