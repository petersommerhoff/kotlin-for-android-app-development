val age = 19
val hasAccess = true

when {
  age < 18 && hasAccess -> println("False positive")
  age > 21 && !hasAccess -> println("False negative")
  else -> println("All working as expected")
}
