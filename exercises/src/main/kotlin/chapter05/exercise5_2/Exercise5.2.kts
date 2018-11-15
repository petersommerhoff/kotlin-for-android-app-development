package chapter05.exercise5_2

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// Using the original class
private val chestOriginal = TreasureChestOriginal()
if (chestOriginal.`is`(TreasureChestOriginal().Diamond())) {  // Must escape `is` because it's a hard keyword
  chestOriginal.open()
  println(chestOriginal.`object`)  // Must escape `object` because it's a hard keyword
  chestOriginal.seal()
}

// Using the improved class
private val chest = TreasureChest()
if (chest.contains(TreasureChest().Diamond())) {
  chest.open()
  println(chest.treasure)
  chest.seal()
}