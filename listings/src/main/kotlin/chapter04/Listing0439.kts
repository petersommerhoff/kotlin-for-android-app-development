enum class PaymentStatus(val billable: Boolean) {  // Enum with a property

  OPEN(true) {
    override fun calculate() { }
  },
  PAID(false) {
    override fun calculate() { }
  };  // Note the semicolon: it separates the enum instances from the members

  fun print() { println("Payment is ${this.name}") }  // Concrete method
  abstract fun calculate()                            // Abstract method
}
// -------------

val status = PaymentStatus.OPEN
val message = when(status) {
  PaymentStatus.PAID -> "Thanks for your payment!"
  PaymentStatus.OPEN -> "Please pay your bill so we can buy coffee."
}  // No else-branch necessary
