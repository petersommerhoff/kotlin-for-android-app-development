package chapter05

// Must rename declarations to avoid name clashes in project
object Cache0518 {
  @JvmStatic fun cache(key: String, obj: Any) { }  // Becomes a static member
}

class Car0518 {
  companion object Factory {
    @JvmStatic fun produceCar() { }                  // Now becomes static as well
  }
}
