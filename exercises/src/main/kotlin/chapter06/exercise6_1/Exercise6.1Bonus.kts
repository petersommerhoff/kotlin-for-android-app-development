package chapter06.exercise6_1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

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

runBlocking {

  var counter = 0
  val lock = Mutex()  // A mutex is the simplest way to implement mutual exclusion

  val coroutines = List(3) {
    launch {
      repeat(1_000_000) {
        lock.withLock {  // Only one coroutine at a time can enter this block to increment the counter
          counter++
        }
      }
    }
  }

  coroutines.forEach { it.join() }

  println("Final counter: $counter")
}