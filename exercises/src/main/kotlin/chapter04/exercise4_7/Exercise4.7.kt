package chapter04.exercise4_7

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// The navigation system can use different strategies
class NavigationSystem {
  fun navigate(destination: Location, strategy: NavigationStrategy = FastestRouteStrategy())
      = strategy.calculateRoute(destination)

  // In reality, the `strategy` function and thus `navigate` would return a route
  fun navigate(destination: Location, strategy: (Location) -> Unit) = strategy(destination)
}

data class Location(val latitude: Double, val longitude: Double)

// Traditional approach: Strategy interface with a subclass for each concrete strategy
interface NavigationStrategy {
  fun calculateRoute(destination: Location)
}

class ShortestRouteStrategy : NavigationStrategy {
  override fun calculateRoute(destination: Location) {
    println("Calculating shortest route...")
  }
}
class FastestRouteStrategy : NavigationStrategy {
  override fun calculateRoute(destination: Location) {
    println("Calculating fastest route...")
  }
}

// Functional approach: algorithms can be extracted and passed as function instead of using inheritance
val shortestRouteStrategy = { location: Location ->
  println("Calculating shortest route to $location (via lambda)...")
}

val fastestRouteStrategy = { location: Location ->
  println("Calculating fastest route to $location (via lambda)...")
}

fun main(args: Array<String>) {
  val navi = NavigationSystem()
  val shortestRoute = ShortestRouteStrategy()
  val stonehenge = Location(51.178883, -1.826215)

  navi.navigate(stonehenge, shortestRoute)
  navi.navigate(stonehenge, fastestRouteStrategy)
}

/*
 * This exercise nicely presents these "new ways of modularity" functional programming enables. Lambda expressions can
 * encapsulate algorithms and make them interchangeable without using inheritance.
 */