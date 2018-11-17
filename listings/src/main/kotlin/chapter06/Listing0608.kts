import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

class User
// ----------

fun fetchUserAsync(): Future<User> { return CompletableFuture() }

// Call-site
val user = fetchUserAsync()  // Asynchrony is explicit, so you expect a Future<User>