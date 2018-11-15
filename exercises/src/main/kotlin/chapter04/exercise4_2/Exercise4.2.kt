package chapter04.exercise4_2

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * Although a square "is-a" rectangle, it requires additional invariants, here width == height.
 * In such scenarios, inheritance may be undesirable. It's useful rather when a subclass really
 * just adds functionality in addition to its superclass.
 *
 * The problem here boils down to the Liskov Substitution Principle (LSP), one of the principles
 * of object-oriented software design. It states that a subclass should always be able to be used
 * in place of its superclass and behave the same way (preserve invariants etc).
 *
 * The takeaway is that object-oriented design, and especially inheritance, are not always the ideal
 * way to model or solve a problem.
 */
open class Rectangle(var width: Double, var height: Double) {
  open fun area() = width * height
  open fun stretch(factor: Double) {
    width *= factor
  }
}

class Square(width: Double) : Rectangle(width, width) {
  override fun stretch(factor: Double) {
    super.stretch(factor)
    height *= factor  // Violates invariant of Rectangle. But otherwise would violate invariant of Square.
  }
}

fun main(args: Array<String>) {
  val rect: Rectangle = Square(10.0)  // Rectangle happens to be a Square at runtime
  rect.stretch(2.0)
  println(rect.height)  // Would expect unchanged 10.0 for a rectangle
  println(rect.width)   // Would expect stretched 20.0 for a rectangle
  println(rect.area())  // Would expect 200.0 for a rectangle that was stretched only in width
}