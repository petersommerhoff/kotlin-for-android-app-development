open class Stack<out E>(vararg elements: E) {  // ‘out’ indicates covariance
  protected open val elements: List<E> = elements.toList()  // E used in out-position
  fun peek(): E = elements.last()                           // E used in out-position
  fun size() = elements.size
}

val stack: Stack<Number> = Stack<Int>(1, 2, 3)  // Allowed because covariant
