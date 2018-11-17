import chapter05.Listing0506.myListOf

val list = myListOf("a", "b", "c")                 // Can pass in any number of args
val values = arrayOf("d", "e", "f")
val list2 = myListOf(*values)                      // Spread operator required
