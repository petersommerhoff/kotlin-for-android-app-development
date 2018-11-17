data class Person(val spouse: String?) {
  fun getSpouseOrNull() = spouse
}

fun getPersonOrNull(): Person? = Person(null)
// ----------------

val person: Person? = getPersonOrNull()

if (person != null) {
  person.getSpouseOrNull()              // Let's say returns null
} else {
  println("No person found (if/else)")  // Not printed
}

person?.let {
  person.getSpouseOrNull()              // Let's say returns null
} ?: println("No person found (let)")   // Printed
