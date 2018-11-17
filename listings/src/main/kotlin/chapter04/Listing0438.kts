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

val status = PaymentStatus.PAID
status.print()  // Prints "Payment is PAID"
status.calculate()

// Kotlin generates ‘name’ and ‘ordinal’ properties
println(status.name)      // PAID
println(status.ordinal)   // 1
println(status.billable)  // false

// Enum instances implement Comparable (order = order of declaration)
println(PaymentStatus.PAID > PaymentStatus.OPEN)  // true

// ‘values’ gets all possible enum values
var values = PaymentStatus.values()
println(values.joinToString())  // OPEN, PAID

// ‘valueOf’ retrieves an enum instance by name
println(PaymentStatus.valueOf("OPEN"))  // OPEN
