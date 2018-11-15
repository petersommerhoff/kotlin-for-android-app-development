package chapter06.exercise6_1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

  // This will be our *shared mutable state* (you should already cringe at the sound of those words)
  var counter = 0

  val coroutines = List(3) {
    // Coroutines are launched from GlobalScope (unless you want children coroutines); since coroutines version 0.26.0
    launch {
      repeat(1_000_000) {
        counter++
      }
    }
  }

  coroutines.forEach { it.join() }

  // What do you think will be the result?
  println("Final counter: $counter")
}

/*
 * What do you see? How can you explain it? Do you know the name of this phenomenon?
 * -> You get random results but almost certainly not 3_000_000 (although that's what you would expect without any
 *    synchronization issues). This can be explained by the fact that the three coroutines concurrently access the
 *    counter and updates of one may overwritten by another and thus lost. The process is this:
 *
 *    Coroutine1 reads `counter`: value is 100
 *    Coroutine1 increments value to 101 (but does not yet write the value back to counter)
 *    Coroutine1 is suspended
 *    Coroutine2 reads `counter`: value is 100
 *    Coroutine2 increments to 101 and writes value: value is now 101
 *    Coroutine2 is suspended
 *    Coroutine1 writes back value: value is still 101
 *    -> Effectively, the counter was increased by 1 but two iterations of incrementing were run
 *
 *  Generally, these types of phenomena can be called synchronization issues because multiple concurrent units compete
 *  for a shared resource so that synchronization becomes necessary. More specifically, the symptom of random counter
 *  results is called a *Heisenbug*. Because it appears randomly and produces unpredictable outcomes, it is extremely
 *  nasty to debug -- so definitely avoid such situations in the first place, e.g., by avoiding shared mutable state.
 */