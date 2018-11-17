package chapter05

const val CONSTANT = 360

object Cache { val obj = "Expensive object here..." }

class Car {
  companion object Factory { val defaultCar = Car() }
}
