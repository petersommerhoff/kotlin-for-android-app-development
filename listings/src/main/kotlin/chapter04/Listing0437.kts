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
