abstract class Component
class Composite : Component()
class Leaf : Component()
// ----------------

val composite: Component = Composite()

val leafOrNull: MyLeaf? = composite as MyLeaf?      // ClassCastException
val leafSafe: MyLeaf?   = composite as? MyLeaf      // Evaluates to null
