val name: String? = "John Doe"
//println(name.length)    // Not safe => causes compile-time error

if (name != null) {     // Explicit null check
  println(name.length)  // Now safe so compiler allows accessing length
}

println(name?.length)            // Safe call operator ‘?’
val upper = name?.toUpperCase()  // Safe call operator
