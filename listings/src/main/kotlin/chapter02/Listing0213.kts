for (i in 1..100) println(i)        // iterating over a range from 1 to 100

for (i in 1 until 100) println(i)   // iterating over a range from 1 to 99

val planets = listOf("Mercury", "Venus", "Earth", "Mars")

for (planet in planets)             // iterating over a collection
  println(planet)

for (character in "Mercury") {      // iterating over a String
  println("$character, ")
}
