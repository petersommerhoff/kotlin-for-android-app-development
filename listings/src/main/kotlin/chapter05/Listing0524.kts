// Must rename declarations to avoid name clashes with previous listing file in this project

fun List<Customer>.validate0524() { }

@JvmName("validateCC")  // Resolves the name clash
fun List<CreditCard>.validate0524() { }

// Both can be called as validate() from Kotlin (because dispatched at compile-time)
val customers = listOf(Customer())
val ccs       = listOf(CreditCard())
customers.validate0524()
ccs.validate0524()
