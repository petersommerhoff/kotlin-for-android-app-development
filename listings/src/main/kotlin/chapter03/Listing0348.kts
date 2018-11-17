fun <T, R> T.let(block:  (T) -> R): R = block(this) // Lambda with parameter (T) -> R
fun <T, R> T.run(block: T.() -> R): R = block()     // Lambda with receiver T.() -> R