interface Kickable {
  fun kick()
}

// Existing implementation of Kickable
class BaseKickHandler : Kickable {
  override fun kick() { println("Got kicked") }
}

// Football implements interface by delegating to existing impl. (zero boilerplate)
class Football(kickHandler: Kickable) : Kickable by kickHandler
