package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * - If one of the numbers is zero, the GCD is defined to be the other number
 * - Otherwise, you can find the GCD using recursion (calling the function inside itself)
 */
fun greatestCommonDivisor(a: Int, b: Int): Int {
  if (a == 0) {
    return b
  }
  return greatestCommonDivisor(b % a, a)
}

/*
 * The implementation above can easily be translated into a single if-expression
 */
fun greatestCommonDivisorShort(a: Int, b: Int): Int =
    if (a == 0) b else greatestCommonDivisorShort(b % a, a)

/*
 * As a bonus sidenote for the interested, the implementation above is actually *tail-recursive*
 * because the only recursive call appears as the last statement inside the function body. Kotlin
 * allows you to mark such function as `tailrec` to let the compiler do additional optimizations.
 */
tailrec fun greatestCommonDivisorTailrec(a: Int, b: Int): Int =
    if (a == 0) b else greatestCommonDivisorTailrec(b % a, a)

/*
 * For two numbers a and b, it holds that gcd(a,b) * lcm(a,b) = a * b
 * Therefore, lcm(a,b) = a*b / gcd(a,b)
 */
fun leastCommonMultiple(a: Int, b: Int): Long = a.toLong() * b / greatestCommonDivisor(a, b)

/*
 * Sanity-checks the two functions using a few sample inputs (this is not a proper test!)
 */
for (a in arrayOf(6, 8, 15, 27, 34, 120)) {
  for (b in arrayOf(2, 3, 9, 17)) {
    println("GCD($a, $b) = ${greatestCommonDivisorShort(a, b)}")
    println("LCM($a, $b) = ${leastCommonMultiple(a, b)}")
  }
}