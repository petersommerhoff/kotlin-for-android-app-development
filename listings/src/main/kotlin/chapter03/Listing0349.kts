// Can use eager collection and lazy sequence in same way
val animals = listOf("Dog", "Cat", "Chicken", "Frog")  // Eager
//val animals = sequenceOf("Dog", "Cat", "Chicken", "Frog")  // Lazy

animals.filter { it.startsWith("C") }
    .map { "$it starts with a ‘C’" }
    .take(1)
