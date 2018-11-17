val inputString = "4815162342"

val input: Int? = try {
  inputString.toInt()  // Tries to parse input to an integer
} catch (e: NumberFormatException) {
  null                 // Returns null if input could not be parsed to integer
}
