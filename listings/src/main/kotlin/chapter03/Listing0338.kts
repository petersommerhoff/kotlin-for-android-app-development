val essay = with(StringBuilder()) {  // String builder only accessible inside lambda
  appendln("Intro")
  appendln("Content")
  appendln("Conclusion")
  toString()
}

println(essay)