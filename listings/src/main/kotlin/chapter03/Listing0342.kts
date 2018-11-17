data class User(val username: String, val paid: Boolean)
// ----------

fun renderUsername(user: User) = user.run {
  val premium = if (paid) " (Premium)" else ""  // Accesses user.paid
  val displayName = "$username$premium"         // Accesses user.username
  println(displayName)
}
