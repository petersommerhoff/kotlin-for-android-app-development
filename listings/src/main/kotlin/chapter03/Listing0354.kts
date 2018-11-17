val cities = listOf("Warsaw", "London", "Washington", "Paris", "Beijing")
// ---------------

// Not good
println(cities.filter { it.startsWith("W") }
    .map { "City: $it" }  // Calls map before take (could be a million map calls)
    .take(20)             // Takes only the first 20 results
    .joinToString())

// Better
println(cities.filter { it.startsWith("W") }
    .take(20)             // Reduces the size of the collection earlier
    .map { "City: $it" }  // Calls map at most 20 times
    .joinToString())
