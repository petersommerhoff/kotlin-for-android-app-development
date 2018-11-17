data class Car(val model: String, val maxSpeed: Int) {
  companion object Factory {
    fun defaultCar() = Car("SuperCar XY", 360)
  }
}

val car = Car.defaultCar()  // Calls companion method: same as Car.Factory.defaultCar()
