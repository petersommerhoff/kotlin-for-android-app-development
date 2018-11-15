package chapter02

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun printMultiplicationTable(rows: IntRange, columns: IntRange) {
  for (row in rows) {
    for (col in columns) {
      System.out.format("%-8d", row * col)  // Left-aligned output with 8 chars space per column
    }
    println()
  }
}

printMultiplicationTable(rows = 1..5, columns = 1..10)