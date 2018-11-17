val countryToCapital: MutableMap<String, String>? = mutableMapOf("Germany" to "Berlin")

val countries = countryToCapital?.run {  // Runs block only if not null
  putIfAbsent("Mexico", "Mexico City")
  putIfAbsent("Germany", "Berlin")
  keys
}

println(countryToCapital)  // {Germany=Berlin, Mexico=Mexico City}
println(countries)         // ["Germany", "Mexico"]
