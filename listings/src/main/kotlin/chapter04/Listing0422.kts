class Person(val name: String)
// ------------

class Task(val title: String, var priority: Int) {                      // Primary
  constructor(person: Person) : this("Meet with ${person.name}", 50) {  // Secondary
    println("Created task to meet ${person.name}")
  }
}
