val countryToCapital = mutableMapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
// ------------

countryToCapital.apply {
  putIfAbsent("India", "Delhi") // Accesses ‘countryToCapital’ methods without prefix
  putIfAbsent("France", "Paris")
}

println(countryToCapital)  // {"Germany"="Berlin", "France"="Paris", "India"="Delhi"}
