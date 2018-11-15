package chapter06.exercise6_2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import java.net.URL

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * These exercise solutions use Kotlin 1.3 along with a newer coroutines version that uses structured concurrency -- a
 * fascinating concept that makes your concurrent code more predictable and easier to reason about. It's used since
 * version 0.26.0: https://github.com/Kotlin/kotlinx.coroutines/releases/tag/0.26.0
 *
 * Additionally, the syntax change a little. Read about the changes here:
 * 1) Structured concurrency: https://medium.com/@elizarov/structured-concurrency-722d765aa952
 * 2) Kotlin 1.3: https://kotlinlang.org/docs/reference/whatsnew13.html
 */

private val API_URL = "http://api.icndb.com/jokes/random"
val randomJokeUrl = URL(API_URL)

runBlocking {

  println(fetchJoke())

  do {
    print("> Hit ENTER for 3 more jokes or 'q' to quit")
    val input = readLine()!!
    if (input.isBlank()) {
      fetchJokesParallel(count = 3)
    }
  } while(input != "q")
}

suspend fun fetchJokesParallel(count: Int) = coroutineScope {
  withTimeoutOrNull(1000) {  // This is the only change required (along with the elvis operator below)
    repeat(count) {
      launch {
        val joke = fetchJoke()
        println(joke)
      }
    }
  } ?: println("Error: Timed out while fetching jokes. Please retry.")
}

fun fetchJoke(): String {
  val json = randomJokeUrl.readText()
  val regex = Regex("\"joke\": \"(.*)\",")
  val joke = regex.find(json)?.groupValues?.get(1) ?: ""  // Returns the match from the first parentheses
  return joke
}