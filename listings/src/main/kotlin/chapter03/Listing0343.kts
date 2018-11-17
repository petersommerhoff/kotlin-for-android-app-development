data class User(val age: Int, val score: Int, val monthlyFee: Int)
fun fetchUser(): User? = User(21, 1337, 29)

val user = fetchUser().also {
  requireNotNull(it)
  require(it!!.monthlyFee > 0)
}