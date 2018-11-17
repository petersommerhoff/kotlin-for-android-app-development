operator fun Int.times(str: String) = str.repeat(this)

val message = 3 * "Kotlin "  // Still results in "Kotlin Kotlin Kotlin "
