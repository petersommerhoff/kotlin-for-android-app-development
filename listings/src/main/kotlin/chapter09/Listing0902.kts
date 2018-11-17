class User
// ------------

fun user(init: User.() -> Unit): User {
  val user = User()
  user.init()
  return user
}
