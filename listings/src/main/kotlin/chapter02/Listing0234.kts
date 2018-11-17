val name: String? = "Peter"

fun greet(name: String) = println("Hi $name!")

greet(name!!)               // Better be sure that ‘name’ cannot be null here
greet(name ?: "Anonymous")  // Safe alternative using elvis operator
