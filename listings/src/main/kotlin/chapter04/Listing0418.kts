class Company {
  val yearlyRevenue = 10_000_000

  class Nested {
    val company = Company()      // Must create instance of outer class manually
    val revenue = company.yearlyRevenue
  }

  inner class Inner {
    val revenue = yearlyRevenue  // Has access to outer class members automatically
  }
}
