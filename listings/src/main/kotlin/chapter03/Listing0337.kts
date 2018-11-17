val countryToCapital = mutableMapOf("Germany" to "Berlin")

val countries = with(countryToCapital) {
  putIfAbsent("England", "London")
  putIfAbsent("Spain", "Madrid")
  keys  // Defines return value of the lambda, and therefore of ‘with’
}

println(countryToCapital) // {"Germany"="Berlin","England"="London","Spain"="Madrid"}
println(countries)        // ["Germany", "England", "Spain"]
