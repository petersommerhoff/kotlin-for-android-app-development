val votes = listOf(true, false, false, true)    // Creates a read-only list
val countryToCapital = mapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
val testData = arrayOf(0, 1, 5, 9, 10)          // Creates an array (mutable)
// ------------

votes[1]     // false
testData[2]  // 5
countryToCapital["Germany"]  // "Berlin"
