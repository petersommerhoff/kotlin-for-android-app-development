class Task(title: String, priority: Int) {
  val title: String = title
    get() = field.toUpperCase()  // Defines custom getter

  var priority: Int = priority
    get() = field                // Same as default implementation, no need to define
    set(value) {                 // Defines custom setter
      if (value in 0..100) field = value else throw IllegalArgumentException("…")
    }
}

val laundry = Task("Do laundry", 40)
println(laundry.title)           // Calls getter, returns "DO LAUNDRY"
laundry.priority = 150           // Calls setter, throws IllegalArgumentException
println(laundry.priority)        // Calls getter, returns 40
