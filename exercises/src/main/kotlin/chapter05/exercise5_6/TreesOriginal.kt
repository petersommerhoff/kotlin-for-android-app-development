package chapter05.exercise5_6

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Assume this file had the file name "Trees.kt"

// Elements in this tree may change but its structure remains.
// Modifying this class is not part of the exercise but feel free to do so.
sealed class Tree<T>

data class Leaf<T>(var value: T) : Tree<T>()
data class Branch<T>(var value: T, val children: List<Tree<T>>) : Tree<T>() {
  init {
    require(children.isNotEmpty())
  }
}

fun <T> applyToAllNodes(transform: (T) -> T, tree: Tree<T>) {
  when (tree) {
    is Leaf -> tree.value = transform(tree.value)  // Modifies the tree in-place (mutable)
    is Branch -> {
      tree.value = transform(tree.value)
      tree.children.forEach { subtree -> applyToAllNodes(transform, subtree) }
    }
  }
}