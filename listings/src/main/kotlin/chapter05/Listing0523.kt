class Customer
class CreditCard
// -----------------

// Have the same JVM signature: validate(java.util.List)
fun List<Customer>.validate() {}
//fun List<CreditCard>.validate() {}  // Clashing JVM signature
