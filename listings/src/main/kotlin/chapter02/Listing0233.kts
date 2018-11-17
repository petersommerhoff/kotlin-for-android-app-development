val name: String? = "John Doe"  // May also be null
val len = name!!.length         // Asserts the compiler that name is not null; unsafe access
