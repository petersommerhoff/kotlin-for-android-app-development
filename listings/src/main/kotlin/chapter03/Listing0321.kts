val votes = listOf(true, false, false, true)    // Creates a read-only list
// ------------

val numberOfYesVotes = votes.filter { it == true }.count()  // Counts positive votes