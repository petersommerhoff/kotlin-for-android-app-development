infix fun Int.times(str: String) = str.repeat(this)

val message = 3 times "Kotlin "  // Results in "Kotlin Kotlin Kotlin "
