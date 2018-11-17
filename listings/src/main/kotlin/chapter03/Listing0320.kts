val votes = mutableListOf(true, false, false, true)    // Creates a read-only list
val countryToCapital = mutableMapOf(                   // Creates a read-only map
    "Germany" to "Berlin", "France" to "Paris")
val testData = arrayOf(0, 1, 5, 9, 10)          // Creates an array (mutable)
// ------------

// Assumes mutable collections now
votes[1] = true                       // Replaces second element with true
testData[2] = 4                       // Replaces third element with 4
countryToCapital["Germany"] = "Bonn"  // Replaces value for key "Germany"
