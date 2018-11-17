import chapter05.Listing0503.hello

val str = hello()                // Inferred type: String (by default)
println(str.length)

val nullable: String? = hello()  // Explicit type: String?
println(nullable?.length)
