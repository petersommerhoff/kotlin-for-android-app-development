import java.time.LocalDate

data class User(val username: String, val birthday: LocalDate, val address: Address)

data class Address(
    val street: String,
    val number: Int,
    val postCode: String,
    val city: String
)
