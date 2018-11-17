val countryToCapital = mapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
// ------------

val searchResult = countryToCapital.keys.filter { it.toUpperCase().startsWith('F') }