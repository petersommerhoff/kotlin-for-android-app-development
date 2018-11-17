data class User(val username: String, val isActive: Boolean)
val users = listOf(User("admin", true), User("guest", false), User("foo", true))
// ----------

val activeUserNames = users.filter { it.isActive }  // Filter active users
    .take(10)              // Take first ten users
    .map { it.username }   // Extract their usernames

println(activeUserNames)