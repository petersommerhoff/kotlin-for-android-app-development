import java.time.LocalDate

class Address
// ------------

data class User(
    var username: String = "",
    var birthday: LocalDate? = null,
    var address: Address? = null
)
