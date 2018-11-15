package chapter04.exercise4_3

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
open class SinglyLinkedList<out E>(vararg elements: E) : Iterable<E> {

  val head: Node

  interface Node
  class SinglyLinkedNode<out E>(val value: E, val tail: Node) : Node
  class Sentinel : Node

  init {
    var nextNode: Node = Sentinel()
    for (element in elements.reversed()) {  // Builds up structure backwards, starting at the sentinel
      nextNode = SinglyLinkedNode(element, nextNode)
    }
    head = nextNode
  }

  override operator fun iterator(): Iterator<E> = object : Iterator<E> {
    var currentNode: Node = head

    override fun hasNext(): Boolean = currentNode !is Sentinel

    override fun next(): E = (currentNode as SinglyLinkedNode<E>).value.also {
      currentNode = (currentNode as SinglyLinkedNode<*>).tail
    }
  }

  operator fun get(index: Int) = when (head) {
    is SinglyLinkedNode<*> -> this.elementAt(index)
    is Sentinel -> throw IndexOutOfBoundsException("Singly linked list is empty.")
    else -> throw IllegalStateException("This should not happen: Node should either be Sentinel or SinglyLinkedNode.")
  }

  operator fun contains(element: @UnsafeVariance E) = this.any { it == element }
}

// Simple test run
fun main(args: Array<String>) {

  val list = SinglyLinkedList(1, 2, 3, 4, 5)

  for (element in list) {  // Uses `iterator`
    println("Next element: $element")
  }

  list.filter { it > 2 }.map { it * 2 }.forEach(::println)  // Only works for `Iterable`s

  println(3 in list)  // Uses `contains`
  println(9 in list)

  println(list[0])    // Uses `get`
  println(list[3])
  println(list[5])    // Should throw OutOfBoundsException
}

/*
 * Singly linked lists take up less memory than doubly-linked lists since only half as many pointers are stored (except
 * if some clever optimizations are applied that are possible in some languages).
 * Also, in mutable implementations, fewer links have to be adjusted to add and remove elements.
 * The read-only version in this exercise enables another interesting feature called structure sharing, which means that
 * the tail can easily be the tail of multiple heads -- this doesn't work in doubly-linked lists.
 *
 * On the other hand, removing is easier in doubly-linked lists because you need to get a reference to the previous
 * element in order to adjust the links (and doubly-linked nodes have a pointer to their previous element).
 *
 * Array lists allow very efficient (constant-time) access at any index but adding and removing elements can be hard
 * once the underlying array runs out of space. This is good for lists where you primarily read from random indices.
 */