val countryToCapital = mapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
// ------------

val countries = countryToCapital.map { it.key }  // ["Germany", "France"]
println(countries)