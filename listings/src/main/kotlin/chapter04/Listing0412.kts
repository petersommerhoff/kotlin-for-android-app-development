enum class Mood { GRUMPY, HUNGRY, SLEEPY }
// -------------

class JsonPerson(properties: Map<String, Any>) {
  val name: String by properties  // Delegates property to the map
  val age: Int by properties      // Delegates property to the map
  val mood: Mood by properties    // Delegates property to the map
}

// Assume the data comes from JSON; keys in the map must match property names
val jsonData = mutableMapOf("name" to "John Doe", "age" to 42, "mood" to "GRUMPY")

// You may need to preprocess some data (requires MutableMap)
jsonData["mood"] = Mood.valueOf(jsonData["mood"] as String)  // ‘valueOf’ is built-in

// Creates an object from map
val john = JsonPerson(jsonData)  // Properties are matched to the keys in the map
println(john.name)  // "John Doe"
println(john.age)   // 42
println(john.mood)  // GRUMPY

// Read-only property changes if backing map changes
jsonData["name"] = "Hacker"
println(john.name)  // Prints "Hacker"
