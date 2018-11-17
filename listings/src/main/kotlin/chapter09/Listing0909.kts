data class Address(
    val street: String,
    val number: Int,
    val postCode: String,
    val city: String
)
// -----------------

class AddressBuilder {
  var street = ""
  var number = -1
  var postCode = ""
  var city = ""

  fun build(): Address {
    if (notReady())
      throw IllegalStateException("Please set street, number, postCode, and city.")

    return Address(street, number, postCode, city)
  }

  private fun notReady()
      = arrayOf(street, postCode, city).any { it.isBlank() } || number <= 0
}
