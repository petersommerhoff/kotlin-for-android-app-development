import java.util.*

fun <T> myListOf(vararg elements: T) = Arrays.asList(*elements) // * is spread operator

val list0: List<Int> = myListOf<Int>(1, 2, 3)  // All types explicit, no type inference
val list1: List<Int> = myListOf(1, 2, 3)  // Infers myListOf<Int>
val list2 = myListOf(1, 2, 3)             // Infers MutableList<Int> and myListOf<Int>
val list3 = myListOf<Number>(1, 2, 3)     // Infers MutableList<Number>

// Without parameters
val list4 = myListOf<Int>()               // Infers MutableList<Int>
val list5: List<Int> = myListOf()         // Infers myListOf<Int>
