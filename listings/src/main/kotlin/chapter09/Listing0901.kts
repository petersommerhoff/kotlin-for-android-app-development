import java.time.LocalDate
import java.time.Month

fun user(init: User.() -> Unit) = User().apply(init)
infix fun Int.January(year: Int) = LocalDate.of(year, Month.JANUARY, this)

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
  username = "johndoe"
  birthday = 1 January 1984
  address {
    street = "Main Street"
    number = 42
    postCode = "12345"
    city = "New York"
  }
}
