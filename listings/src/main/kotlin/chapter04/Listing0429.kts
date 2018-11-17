abstract class Component
class Composite : Component()
class Leaf : Component()
// ----------------

val item: Component? = null

val leaf: MyLeaf        = item as MyLeaf               // TypeCastException
val leafOrNull: MyLeaf? = item as MyLeaf?              // Evaluates to null
val leafSafe: MyLeaf?   = item as? MyLeaf              // Evaluates to null
val leafNonNull: MyLeaf = (item as? MyLeaf) ?: MyLeaf()  // Alternative using elvis op.
