fun countOccurrences(of: Char, inStr: String): Int {
  return inStr.count { it == of }
}

val count: (Char, String) -> Int = ::countOccurrences  // Function reference matches function type