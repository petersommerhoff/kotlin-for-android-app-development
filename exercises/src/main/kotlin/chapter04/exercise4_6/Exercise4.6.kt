package chapter04.exercise4_6

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// You may also model this as just a single class `TreeNode` and decide if it's a branch or leaf via its no. of children
sealed class TreeNode<T>(var value: T, val children: List<TreeNode<T>>)

class Branch<T>(value: T, children: List<TreeNode<T>>) : TreeNode<T>(value, children) {
  override fun toString(): String = "{$value, ${children.map { it.toString() }}}"
}

class Leaf<T>(value: T) : TreeNode<T>(value, emptyList<TreeNode<T>>()) {  // `emptyList` does not allow adding elements
  override fun toString(): String = "{$value}"
}

fun <T> visitDepthFirst(root: TreeNode<T>, transform: (TreeNode<T>) -> Unit): Unit = when (root) {
  is Leaf -> transform(root)
  is Branch -> {
    transform(root)
    root.children.forEach { visitDepthFirst(it, transform) }
  }
}

fun <T> visitBreadthFirst(root: TreeNode<T>, transform: (TreeNode<T>) -> Unit): Unit = when (root) {
  is Leaf -> transform(root)
  is Branch -> {
    transform(root)
    visit(root, transform)
  }
}

private fun <T> visit(node: TreeNode<T>, transform: (TreeNode<T>) -> Unit): Unit {
  node.children.forEach { transform(it) }
  node.children.forEach { visit(it, transform) }
}

fun main(args: Array<String>) {

  // Builds up the tree from Figure 4.3 in the Instructor's Manual
  val tree = Branch(1, listOf(
      Branch(2, listOf(
          Leaf(5)
      )),
      Leaf(3),
      Branch(4, listOf(
          Branch(6, listOf(
              Leaf(8)
          )),
          Leaf(7)
      ))
  ))

  println("Original: $tree")
  visitDepthFirst(tree) { it.value = it.value * 2 }
  println("Times two: $tree")
  visitDepthFirst(tree) { it.value = it.value - 1 }
  println("Minus one: $tree")

  visitBreadthFirst(tree) { it.value = (it.value + 1) / 2 }
  println("Back to original: $tree")

  visitBreadthFirst(tree) { print("${it.value}, ") }
  println()
  visitDepthFirst(tree) { print("${it.value}, ") }
}