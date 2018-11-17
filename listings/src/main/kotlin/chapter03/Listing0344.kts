data class User(val age: Int, val score: Int, val monthlyFee: Int)
val users = listOf(User(11, 9000, 0), User(22, 3439, 19), User(42, 984, 99))
// -------------

users.filter { it.age > 21 }
    .also { println("${it.size} adult users found.") }  // Intercepts chain
    .map { it.monthlyFee }

println(users)