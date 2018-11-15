package chapter02

import java.util.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

val numberToGuess = Random().nextInt(100) + 1
var userGuess = -1
println("Guess the number between 1 and 100!")

do {
  print("> ")
  userGuess = try {
    readLine()!!.toInt()  // `readLine` cannot return null when using the command-line
  } catch (e: Exception) {
    println("Not a valid guess, please enter a number between 1 and 100")
    continue
  }
  when {
    userGuess < numberToGuess -> println("Too low!")
    userGuess == numberToGuess -> println("Congratulations, $userGuess is the correct number!")
    userGuess > numberToGuess -> println("Too high!")
  }
} while (userGuess != numberToGuess)