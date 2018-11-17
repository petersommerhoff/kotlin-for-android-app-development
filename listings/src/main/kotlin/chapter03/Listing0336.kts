val countryToCapital = mutableMapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
// ------------

countryToCapital.apply {
  putIfAbsent("China", "Beijing")
}.filter {
  it.key.startsWith("C")
}.map {
  it.value.toUpperCase()
}