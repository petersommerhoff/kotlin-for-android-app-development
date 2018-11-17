import java.time.LocalDate

data class User(
    var username: String = "",
    var birthday: LocalDate? = null,
    var address: Address? = null
) {
  fun address(init: Address.() -> Unit) {
    address = Address().apply(init)
  }
}

data class Address(
    var street: String = "",
    var number: Int = -1,
    var postCode: String = "",
    var city: String = ""
)
