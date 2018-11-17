open class Stack<out E>(vararg elements: E) {  // ‘out’ indicates covariance
  protected open val elements: List<E> = elements.toList()  // E used in out-position
  fun peek(): E = elements.last()                           // E used in out-position
  fun size() = elements.size
}
// ----------

class MutableStack<E>(vararg elements: E) : Stack<E>() {  // Mutable: must be invariant
  override val elements: MutableList<E> = elements.toMutableList()
  fun push(element: E) = elements.add(element)
  fun pop() = elements.removeAt(elements.size - 1)
}

//val mutable: MutableStack<Number> = MutableStack<Int>(1, 2, 3)  // Compile-time error
