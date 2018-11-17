data class Contact(val name: String, val phone: String, var favorite: Boolean)
// --------------

val john = Contact("John", "202-555-0123", true)
val john2 = Contact("John", "202-555-0123", true)
val jack = Contact("Jack", "202-555-0789", false)

// toString
println(jack)               // Contact(name=Jack, phone=202-555-0789, favorite=false)

// equals
println(john == john2)      // true
println(john == jack)       // false

// hashCode
val contacts = hashSetOf(john, jack, john2)
println(contacts.size)      // 2 (no duplicates in sets, uses hashCode)

// componentN
val (name, phone, _) = john          // Uses destructuring declaration
println("$name's number is $phone")  // John's number is 202-555-0123

// copy
val johnsSister = john.copy(name = "Joanne")
println(johnsSister)  // Contact(name=Joanne, phone=202-555-0123, favorite=true)
