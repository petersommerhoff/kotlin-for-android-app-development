//val normal: MutableList<Number> = mutableListOf<Int>(1, 2, 3)  // Compile-time error
val producer: MutableList<out Number> = mutableListOf<Int>(1, 2, 3)  // Now covariant

// Can only read from producer, not write to it
//producer.add(???)            // Parameter type is Nothing, so impossible to call add()
val n: Number = producer[0]  // Returns Number
