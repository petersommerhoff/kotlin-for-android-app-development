open class Stack<out E>(vararg elements: E) {  // ‘out’ indicates covariance
  protected open val elements: List<E> = elements.toList()  // E used in out-position
  fun peek(): E = elements.last()                           // E used in out-position
  fun size() = elements.size
}

class MutableStack<E>(vararg elements: E) : Stack<E>() {  // Mutable: must be invariant
  override val elements: MutableList<E> = elements.toMutableList()
  fun push(element: E) = elements.add(element)
  fun pop() = elements.removeAt(elements.size - 1)
}
// ----------

fun <E> transfer(from: MutableStack<out E>, to: MutableStack<in E>) {
  // Same as before
  while (from.size() > 0) { to.push(from.pop()) }
}

val from = MutableStack<Int>(1, 2, 3)
val to = MutableStack<Number>(9.87, 42, 1.23)
transfer(from, to)  // Works now due to variance
