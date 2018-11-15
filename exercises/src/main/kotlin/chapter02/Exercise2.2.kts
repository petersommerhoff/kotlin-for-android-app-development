package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Reads and parses command-line argument, handles possible exceptions
val rows = try {
  require(args[0].toInt() >= 3)
  args[0].toInt()
} catch (e: IllegalArgumentException) {
  System.err.println("Please use a tree size of at least 3. Using default size of 5...")
  5
} catch (e: ArrayIndexOutOfBoundsException) {
  System.err.println("Please specify the tree size as command-line parameter. Using default size of 5...")
  5
} catch (e: NumberFormatException) {
  System.err.println("Command-line argument must be an integer. Using default size of 5...")
  5
}

// Extracts relevant data
val treeWidth = (rows * 2) - 1
val treeMiddle = treeWidth / 2

// Prints tree 'leaves'
for (row in 0 until rows) {
  for (i in 1..treeMiddle - row) print(" ")
  for (i in 1..(2 * row + 1)) print("#")
  println()
}

// Prints tree trunk
for (i in 1 until treeMiddle) print(" ")
print("###")
