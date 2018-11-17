data class User(val age: Int, val score: Int, val monthlyFee: Int)
val users = listOf(User(11, 9000, 0), User(22, 3439, 19), User(42, 984, 99))
// -------------

println(users.minBy { it.age })         // Returns user object of youngest user
println(users.maxBy { it.score })       // Returns user object of user with maximum score
println(users.sumBy { it.monthlyFee })  // Returns sum of all users’ monthly fees
