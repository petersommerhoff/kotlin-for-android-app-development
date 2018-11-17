import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Cat {
  var name: String by MyDelegate()  // Delegates to object of class MyDelegate
}
// ------------

class MyDelegate : ReadWriteProperty<Cat, String> {  // Implements ReadWriteProperty
  var name: String = "Felix"

  // Delegate must have a getValue method (and setValue for mutable properties)
  override operator fun getValue(thisRef: Cat, property: KProperty<*>): String {
    println("$thisRef requested ${property.name} from MyDelegate")
    return name
  }

  override operator fun setValue(thisRef: Cat, property: KProperty<*>, value: String) {
    println("$thisRef wants to set ${property.name} to $value via MyDelegate")

    if (value.isNotBlank()) {
      this.name = value
    }
  }
}

val felix = Cat()
println(felix.name)  // "Cat@1c655221 requested name from MyDelegate"
felix.name = "Feli"  // "Cat@1c655221 wants to set name to Feli via MyDelegate"
println(felix.name)  // "Cat@1c655221 requested name from MyDelegate"
