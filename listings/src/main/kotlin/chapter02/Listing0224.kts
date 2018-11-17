/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun Number.print() = println("Number $this")  // Extension on supertype
fun Int.print() = println("Int $this")        // Extension on subtype

val n: Number = 42                            // Statically resolved type: Number
n.print()                                     // Prints "Number 42"
