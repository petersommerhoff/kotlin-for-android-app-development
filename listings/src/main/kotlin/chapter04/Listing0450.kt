// Suffix "Generic" is only to avoid name clashes inside project
sealed class BinaryTreeGeneric<T>  // Now generic: can carry values of any type
data class LeafGeneric<T>(val value: T) : BinaryTreeGeneric<T>()
data class BranchGeneric<T>(
    val left: BinaryTreeGeneric<T>,
    val right: BinaryTreeGeneric<T>
) : BinaryTreeGeneric<T>()

val tree: BinaryTreeGeneric<Double> = LeafGeneric(3.1415)  // Uses a binary tree with Double values
