package chapter05

// Must rename class to avoid name clashes in project
class KotlinClass0511 {
  var mutable: Boolean = false
    @JvmName("isMutable") get         // Specifies custom getter name for Java bytecode
}
