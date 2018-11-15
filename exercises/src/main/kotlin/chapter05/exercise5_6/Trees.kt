/*
 * - Giving the generated class an explicit name prevents ugly "TreesKt" naming and avoids leaking
 *   the implementation to the outside.
 */
@file:JvmName("TreeUtils")

package chapter05.exercise5_6

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * - Extension function allows calling more naturally (from Kotlin)
 * - The concept of this function is that of a `map` function. Calling it `map` thus gets across its
 *   functionality effectively and with a concise name (assuming readers know functional programming)
 * - Making the lambda the last parameter allows calling it without parentheses (from Kotlin)
 *
 * (Making the Tree immutable is definitely another way to improve the code but not assumed as part
 * of the solution here).
 */
fun <T> Tree<T>.map(transform: (T) -> T) {
  when (this) {
    is Leaf -> value = transform(value)
    is Branch -> {
      value = transform(value)
      children.forEach { subtree -> subtree.map(transform) }
    }
  }
}