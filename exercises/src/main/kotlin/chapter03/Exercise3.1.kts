package chapter03

import kotlin.math.pow

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun iterate(repetitions: Int, func: (Double) -> Double): (Double) -> Double = { d: Double ->
  var result = d
  for (i in 1..repetitions) {
    result = func(result)
  }
  result  // Note that this is not the return value of `iterate` -- it's the return value of the returned lambda
}

val plusThree = iterate(3) { it + 1.0 }
println(plusThree(3.1415))  // Note machine precision issue with floating point numbers

val toThePowerOf8 = iterate(3) { it.pow(2) }
println(toThePowerOf8(2.0))
