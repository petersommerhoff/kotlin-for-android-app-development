import kotlin.reflect.KProperty
class MyDelegate {
  operator fun getValue(cat: Cat, property: KProperty<*>): String = ""
  operator fun setValue(cat: Cat, property: KProperty<*>, s: String) {}
}
// -----------

class Cat {
  var name: String by MyDelegate()  // Delegates to object of class MyDelegate
}