package chapter05.exercise5_5

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * A good return type for functions such as `fail` and `exit` is Kotlin's special `Nothing` type.
 */
fun fail(message: String): Nothing = throw IllegalStateException(message)

/*
 * This return type tells the compiler that the function never terminates, and the compiler can use this information to
 * infer interesting data such as nullability.
 */
fun fetchMessage(): String? = "Hello, World!"
val nullable: String? = fetchMessage()
val notNullable: String = fetchMessage() ?: fail("Could not fetch a message.")
// `notNullable` cannot be null here because, if it was, the line above wouldn't terminate so this line wouldn't execute