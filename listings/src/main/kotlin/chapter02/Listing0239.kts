class Bitmap { fun prepareToDraw() {} }
class Card(val bitmap: Bitmap?)

val card = Card(null)
// -----------

val bitmap = card.bitmap ?: throw IllegalArgumentException("Bitmap required")
bitmap.prepareToDraw()  // Known to have type Bitmap here (non-nullable)
