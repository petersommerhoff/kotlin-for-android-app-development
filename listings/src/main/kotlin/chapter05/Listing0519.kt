@file:JvmName("ArrayUtils")
package chapter05

@JvmOverloads  // Triggers generation of overloaded methods in Java bytecode
fun <T> Array<T>.join(delimiter: String = ", ",
                      prefix: String = "",
                      suffix: String = ""): String {
  return this.joinToString(delimiter, prefix, suffix)
}
