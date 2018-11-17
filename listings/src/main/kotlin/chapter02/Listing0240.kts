class Bitmap { fun prepareToDraw() {} }
class Card(val bitmap: Bitmap?)

val card = Card(Bitmap())
// -----------

fun fail(message: String): Nothing {  // Nothing type => function never terminates
  throw IllegalArgumentException(message)
}

val bitmap = card.bitmap ?: fail("Bitmap required")  // Inferred type: Bitmap
bitmap.prepareToDraw()
