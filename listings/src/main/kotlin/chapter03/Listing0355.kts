val cities = listOf("Washington", "Houston", "Seattle", "Worcester", "San Francisco")

val output = cities.filter { println("filter: $it"); it.startsWith("W") }  // Washington,Worcester
    .map { println("map: $it"); "City: $it" }  // City: Washington, City: Worcester
    .take(2)  // Should better be called before ‘map’

println(output)  // Produces Listing 3.56