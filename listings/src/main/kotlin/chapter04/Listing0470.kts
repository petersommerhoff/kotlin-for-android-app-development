open class Vehicle(var damaged: Boolean)
// ------------

interface Repair<in T : Vehicle> {  // Upper bound for T is Vehicle
  fun repair(t: T)
}
