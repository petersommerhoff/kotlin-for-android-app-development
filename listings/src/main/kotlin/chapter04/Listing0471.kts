open class Vehicle(var damaged: Boolean)
// ----------

interface Repairable

interface Repair<in T>
    where T : Vehicle,  // where-clause lists all type bounds
          T : Repairable {
  fun repair(t: T)
}
