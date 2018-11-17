import java.time.LocalDate
import java.time.Month

fun user(init: UserBuilder.() -> Unit) = UserBuilder().apply(init).build()
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

  private fun notReady()
      = arrayOf(street, postCode, city).any { it.isBlank() } || number <= 0
}
data class User(val username: String, val birthday: LocalDate, val addresses: List<Address>)
class UserBuilder {
  var username = ""                     // Gets assigned directly in DSL => public
  var birthday: LocalDate? = null       // Gets assigned directly in DSL => public
  private val addresses: MutableList<Address> = mutableListOf()

  inner class Addresses : ArrayList<Address>() {
    fun address(init: AddressBuilder.() -> Unit) {
      add(AddressBuilder().apply(init).build())
    }
  }

  fun addresses(init: Addresses.() -> Unit) {  // ‘Addresses’ is the receiver now
    addresses.addAll(Addresses().apply(init))
  }

  fun build(): User {
    val theBirthday = birthday
    if (username.isBlank() || theBirthday == null || addresses.isEmpty()) throw IllegalStateException("Please define a username, birthday, and at least one address.")

    return User(username, theBirthday, addresses)
  }
}
// -------------

user {
  username = "johndoe"
  birthday = LocalDate.of(1984, Month.JANUARY, 1)
  addresses {  // New dedicated addresses-block
    address {  // All address-blocks must be placed here
      street = "Main Street"
      number = 42
      postCode = "12345"
      city = "New York"
    }
    address {
      street = "Plain Street"
      number = 1
      postCode = "54321"
      city = "York"
    }
  }
}
