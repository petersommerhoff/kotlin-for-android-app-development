sealed class BinaryTree  // Sealed class with two direct subclasses (and no others)
data class Leaf(val value: Int) : BinaryTree()
data class Branch(val left: BinaryTree, val right: BinaryTree) : BinaryTree()
// -------------

fun main() {
  // Creates a binary tree object
  val tree: BinaryTree = Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Leaf(4))
  println(tree)
}