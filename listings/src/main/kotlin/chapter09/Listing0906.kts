import java.time.LocalDate
import java.time.Month

fun user(init: User.() -> Unit) = User().apply(init)

data class User(
    var username: String = "",
    var birthday: LocalDate? = null,
    var address: Address? = null
) {
  fun address(init: Address.() -> Unit) {
    address = Address().apply(init)
  }
}
data class Address(var street: String = "", var number: Int = -1, var postCode: String = "", var city: String = ""
)
// --------------

user {
  address {
    username = "this-should-not-work"
    user {
      address {
        birthday = LocalDate.of(1984, Month.JANUARY, 1)
      }
    }
  }
}
