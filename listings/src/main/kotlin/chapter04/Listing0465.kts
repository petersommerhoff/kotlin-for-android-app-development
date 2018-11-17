interface Repair<in T> {  // Contravariant
  fun repair(t: T)        // T in in-position
}

open class Vehicle(var damaged: Boolean)
class Bike(damaged: Boolean) : Vehicle(damaged)

class AllroundRepair : Repair<Vehicle> {
  override fun repair(vehicle: Vehicle) {
    vehicle.damaged = false
  }
}

val bikeRepair: Repair<Bike> = AllroundRepair()  // Uses contravariance
