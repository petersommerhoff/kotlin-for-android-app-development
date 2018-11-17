interface CarFactory {
  fun defaultCar(): Car
}

data class Car(val model: String, val maxSpeed: Int) {
  companion object Factory : CarFactory {  // Objects can implement interfaces
    override fun defaultCar() = Car("SuperCar XY", 360)
  }
}
