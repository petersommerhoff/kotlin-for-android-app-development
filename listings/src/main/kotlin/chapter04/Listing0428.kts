abstract class Component
class Composite : Component()
class Leaf : Component()
// ----------------

val item: Component = Leaf()   // ‘item’ is a LeafGeneric at runtime

if (item is Composite) { }   // Checks if ‘item’ is of type Composite at runtime
if (item !is Composite) { }  // Checks if ‘item’ is not a Composite at runtime
