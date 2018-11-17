val cities = listOf("Washington", "Houston", "Seattle", "Worcester", "San Francisco")

val output = cities.asSequence()
    .filter { println("filter: $it"); it.startsWith("W") }
    .map { println("map: $it"); "City: $it" }
    .take(2)  // Should still better be called before map
    .toList()

println(output)  // Produces Listing 3.58