package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Uses local helper functions
fun readTreeHeightFromArgs(fallbackHeight: Int): Int {
  return try {
    args[0].toInt().also { require(it > 3) }  // Parses and validates command-line argument
  } catch (e: NumberFormatException) {
    System.err.println("Command-line argument must be an integer. Using default size of $fallbackHeight...")
    fallbackHeight  // Uses default value in case of exception
  } catch (e: IllegalArgumentException) {
    System.err.println("Please use a tree size of at least 3. Using default size of $fallbackHeight...")
    fallbackHeight
  } catch (e: ArrayIndexOutOfBoundsException) {
    System.err.println("Please specify the tree size as command-line parameter. Using default size of $fallbackHeight...")
    fallbackHeight
  }
}

// Extracts relevant data
val treeHeight = readTreeHeightFromArgs(fallbackHeight = 5)
val treeWidth = (treeHeight * 2) - 1
val treeMiddle = treeWidth / 2  // The center on the horizontal axis

// Uses local helper functions
fun printTreeRow(row: Int) {
  for (i in 1..treeMiddle - row) print(" ")
  for (i in 1..(2 * row + 1)) print("#")
  println()
}

fun printTreeLeaves() {  // Note that these helpers don't need parameters because they can access variables from enclosing scope
  for (row in 0 until treeHeight) {
    printTreeRow(row)
  }
}

fun printTreeTrunk() = printTreeRow(1)  // Trunk is same as second row of tree leaves

fun printTree() {
  printTreeLeaves()
  printTreeTrunk()
}

// Actual program
printTree()