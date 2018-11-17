open class Parent {
  val a = "public"
  internal val b = "internal"
  protected val c = "protected"
  private val d = "private"

  inner class Inner {
    val accessible = "$a, $b, $c, $d"  // All accessible
  }
}

class Child : Parent() {
  val accessible = "$a, $b, $c"        // d not accessible because private
}

class Unrelated {
  val p = Parent()
  val accessible = "${p.a}, ${p.b}"    // p.c, p.d not accessible
}
