import java.time.LocalDate

data class Address(val street: String, val number: Int, val postCode: String, val city: String)
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

  private fun notReady() = arrayOf(street, postCode, city).any { it.isBlank() } || number <= 0
}
data class User(val username: String, val birthday: LocalDate, val addresses: List<Address>)
// -------------

class UserBuilder {

  @Deprecated("Out of scope", ReplaceWith(""), DeprecationLevel.ERROR)
  fun user(init: UserBuilder.() -> Unit): Nothing = error("Cannot access user() here.")

  var username = ""
  var birthday: LocalDate? = null
  val addresses: MutableList<Address> = mutableListOf()

  inner class Addresses : ArrayList<Address>() {
    inline fun address(init: AddressBuilder.() -> Unit) {  // Now inlined
      add(AddressBuilder().apply(init).build())
    }
  }

  inline fun addresses(init: Addresses.() -> Unit) {  // Now inlined
    addresses.addAll(Addresses().apply(init))
  }

  fun build(): User {
    val theBirthday = birthday
    if (username.isBlank() || theBirthday == null || addresses.isEmpty()) throw IllegalStateException("Please define a username, birthday, and at least one address.")

    return User(username, theBirthday, addresses)
  }
}

inline fun user(init: UserBuilder.() -> Unit) =                // Now inlined
    UserBuilder().apply(init).build()
