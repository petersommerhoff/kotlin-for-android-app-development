// Entities are renamed to avoid name clashes
abstract class MyComponent { fun component() {} }
class MyComposite : MyComponent() { fun composite() = 1 }
class MyLeaf : MyComponent() { fun leaf() = 2 }
// ----------------

fun main() {
  val comp: MyComponent? = MyLeaf()  // Type is nullable ‘MyComponent?’

  if (comp != null) { comp.component() }                 // Smart-cast to MyComponent
  if (comp is MyLeaf) { comp.leaf() }                    // Smart-cast to LeafGeneric
  when (comp) {
    is MyComposite -> comp.composite()                   // Smart-cast to MyComponent
    is MyLeaf -> comp.leaf()                             // Smart-cast to LeafGeneric
  }
  if (comp is MyComposite && comp.composite() == 16) {}  // Smart-cast to MyComposite
  if (comp !is MyLeaf || comp.leaf() == 43) {}    // Smart-cast to LeafGeneric inside condition
  if (comp !is MyComposite) return                // Does not work in KTS scripts
  comp.composite()  // Smart-cast to MyComposite (because of return above)
}