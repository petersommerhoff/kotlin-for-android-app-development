val cities = listOf("Washington", "Houston", "Seattle", "Worcester", "San Francisco")
val firstTwo = cities.take(2)  // Washington, Houston
val rest = cities.drop(2)      // Seattle, Worcester, San Francisco
firstTwo + rest == cities      // true

println(firstTwo)
println(rest)
println(firstTwo + rest == cities)