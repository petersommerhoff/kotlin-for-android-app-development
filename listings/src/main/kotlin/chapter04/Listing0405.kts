class Task(var title: String)  // Uses ‘var’ now to be able to call the setter

val laundry = Task("Do laundry")

laundry.title = "Laundry day"  // Calls setter
println(laundry.title)         // Calls getter
