class Task {
  val title: String               // Declares a property

  constructor(title: String) {
    this.title = title            // Initializes the property
  }
}

val dishes = Task("Wash dishes")  // Calls constructor to create Task object
val laundry = Task("Do laundry")  // Calls constructor with a different title
