interface Kickable {
  fun kick()
}
// ------------------

// Implements interface with manual delegation
class Football(val kickHandler: Kickable) : Kickable {
  override fun kick() {
    kickHandler.kick()  // Trivial forwarding; necessary for every interface method
  }
}
