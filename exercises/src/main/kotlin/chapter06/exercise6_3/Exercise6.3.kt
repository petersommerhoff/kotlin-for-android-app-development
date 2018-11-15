package chapter06.exercise6_3

import kotlinx.coroutines.delay

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

fun normal(s: String, i: Int): Boolean {
  return true
}

suspend fun suspendable(s: String, i: Int): Boolean {
  delay(100)
  val a = 10
  delay(100)

  return true
}

/*
 * For the normal function, there's nothing surprising in the bytecode (or the decompiled Java code). The Kotlin
 * compiler makes it a `final` method and adds @NotNull annotations where appropriate.
 *
 * For the suspend function, you can see the result of how the Kotlin compiler treats suspending functions. Before we
 * dive into the method body, let's first recap the transformations regarding the signature:
 * 1) Every suspending function gets an additional Continuation parameter
 * 2) The return type of the suspend function becomes the generic type parameter of the Continuation, so here we get
 *    Continuation<Boolean>. You can only see this in a comment shown in the bytecode:
 *
 *    // declaration:  suspendable(java.lang.String, int, kotlin.coroutines.Continuation<? super java.lang.Boolean>)
 *
 * 3) The return type of the compiled method becomes Any? (or rather Object). Remember that this represents the union
 *    of the original return type (Boolean) and the special COROUTINE_SUSPENDED marker.
 * 4) There's no `suspend` modifier (obviously because it's not something that the JVM offers)
 *
 * Looking at the generated method body, you can see that it implements a simple state machine. There's a `label` that
 * indicates which state you're currently in, and a switch-case statements that runs the piece of the function that
 * corresponds to the current state. In our example:
 * -> We have 2 suspension points (the calls to `delay`)
 * -> Thus, we have 3 states in the state machine (the three blocks of code separated by the delays, including the zero
 *    lines of code before the first delay)
 * -> Thus, the switch-case has 3 cases (one for each state), plus a default case. At the end of each case, the label
 *    is increased by one so that the function knows where to continue later in case it gets suspended.
 *
 * Depending on the structure of your suspend function, the compiler may perform all kinds of optimizations, and the
 * details of code generation will likely keep changing with newer compiler versions but this is the general structure
 * you should see.
 */