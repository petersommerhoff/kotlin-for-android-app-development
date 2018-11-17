val cities = listOf("Warsaw", "London", "Washington", "Paris", "Beijing", "Worcester")
// ---------------

val output = cities.asSequence()  // Transform eager list into a lazy sequence
    .filter { it.startsWith("W") }
    .map { "City: $it" }
    .joinToString()

println(output)  // City: Warsaw, City: Washington, City: …
