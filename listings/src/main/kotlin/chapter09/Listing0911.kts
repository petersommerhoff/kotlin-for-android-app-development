import java.time.LocalDate

data class Address(val street: String, val number: Int, val postCode: String, val city: String)
class AddressBuilder { fun build(): Address = Address("", 1, "", "") }
// ------------

data class User(val username: String, val birthday: LocalDate, val addresses: List<Address>)

class UserBuilder {
  var username = ""                     // Gets assigned directly in DSL => public
  var birthday: LocalDate? = null       // Gets assigned directly in DSL => public
  private val addresses: MutableList<Address> = mutableListOf()

  fun address(init: AddressBuilder.() -> Unit) {
    addresses.add(AddressBuilder().apply(init).build())
  }

  fun build(): User {  // Validates data and builds user object
    val theBirthday = birthday
    if (username.isBlank() || theBirthday == null || addresses.isNotEmpty())
      throw IllegalStateException("Please set username, birthday, and address.")

    return User(username, theBirthday, addresses)
  }
}