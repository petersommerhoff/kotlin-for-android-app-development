val languages = setOf("Kotlin", "Java", "C++")  // Creates a read-only set
val votes = listOf(true, false, false, true)    // Creates a read-only list
val countryToCapital = mapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
val testData = arrayOf(0, 1, 5, 9, 10)          // Creates an array (mutable)
// ------------

println(languages.sorted())              // ["C++", "Java", "Kotlin"]
println(languages.sortedDescending())    // ["Kotlin", "Java", "C++"]
println(testData.sortedBy { it % 3 })    // [0, 9, 1, 10, 5]
println(votes.sortedWith(
    Comparator { o1, _ -> if (o1 == true) -1 else 1 })) // [true, true, false, false]
println(countryToCapital.toSortedMap())  // {France=Paris, Germany=Berlin}
