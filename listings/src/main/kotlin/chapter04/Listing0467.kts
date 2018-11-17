//val normal: MutableList<Int> = mutableListOf<Number>(1.7, 2f, 3)  // Compile-time error
val consumer: MutableList<in Int> = mutableListOf<Number>(1.7, 2f, 3)  // Contravariant

// Can write to consumer normally, but only read values as Any?
consumer.add(4)
val value: Any? = consumer[0]  // Return type is Any? (only type-safe choice)
