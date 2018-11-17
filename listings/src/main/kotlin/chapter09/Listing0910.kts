import java.time.LocalDate

data class User(val username: String, val birthday: LocalDate, val address: Address)
data class Address(val street: String, val number: Int, val postCode: String, val city: String)
class AddressBuilder { fun build(): Address = Address("", 1, "", "") }
class UserBuilder {
  var username = ""                     // Gets assigned directly in DSL => public
  var birthday: LocalDate? = null       // Gets assigned directly in DSL => public
  private var address: Address? = null  // Is built via builder => private

  fun address(init: AddressBuilder.() -> Unit) {  // Nested function to build address
    address = AddressBuilder().apply(init).build()
  }

  fun build(): User {  // Validates data and builds user object
    val theBirthday = birthday
    val theAddress = address
    if (username.isBlank() || theBirthday == null || theAddress == null)
      throw IllegalStateException("Please set username, birthday, and address.")

    return User(username, theBirthday, theAddress)
  }
}
// ----------------

fun user(init: UserBuilder.() -> Unit) = UserBuilder().apply(init).build()