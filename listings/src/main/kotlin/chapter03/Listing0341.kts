fun getUsername() = "guest"
fun getPassword() = ""
fun validate(name: String, pw: String) = (name == "guest" && pw == "")
// ---------

val success = run {
  val username = getUsername()  // Only visible inside this lambda
  val password = getPassword()  // Only visible inside this lambda

  validate(username, password)
}

println(success)