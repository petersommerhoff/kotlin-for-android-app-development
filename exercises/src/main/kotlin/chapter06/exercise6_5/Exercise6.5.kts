package chapter06.exercise6_5

import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.math.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * These exercise solutions use Kotlin 1.3 along with a newer coroutines version that uses structured concurrency -- a
 * fascinating concept that makes your concurrent code more predictable and easier to reason about. It's used since
 * version 0.26.0: https://github.com/Kotlin/kotlinx.coroutines/releases/tag/0.26.0
 *
 * Additionally, the syntax change a little. Read about the changes here:
 * 1) Structured concurrency: https://medium.com/@elizarov/structured-concurrency-722d765aa952
 * 2) Kotlin 1.3: https://kotlinlang.org/docs/reference/whatsnew13.html
 */

data class Location(val lat: Double, val lng: Double)

val earthRadiusInKm = 6378.137

val houseLocation = Location(38.897675, -77.036530)

/**
 * Uses the haversine algorithm which is numerically stable even for low distances.
 */
fun distanceInMeters(a: Location, b: Location): Double {
  val deltaLat = (b.lat - a.lat).toRadians()
  val deltaLng = (b.lng - a.lng).toRadians()
  val sinDeltaLat = sin(deltaLat / 2)
  val sinDeltaLng = sin(deltaLng / 2)

  val squareOfHalfChordLength = sinDeltaLat.pow(2) + sinDeltaLng.pow(2) * cos(a.lat.toRadians()) * cos(b.lat.toRadians())
  val angularDistance = 2 * atan2(sqrt(squareOfHalfChordLength), sqrt(1 - squareOfHalfChordLength))

  return earthRadiusInKm * angularDistance * 1000
}

fun Double.toRadians() = (this * PI / 180.0)

runBlocking {

  val watcher = actor<Location> {
    consumeEach {  dogLocation ->
      val distanceFromHouse = distanceInMeters(houseLocation, dogLocation)
      println("Current distance: ${distanceFromHouse}m \t\t-- Dog is at (${dogLocation.lat}, \t${dogLocation.lng})")
      if (distanceFromHouse >= 20.0) {
        println("WARNING: Dog may be at neighbors' again!")
      }
    }
  }

  produce<Location> {
    var dogLocation = houseLocation
    while(true) {
      watcher.send(dogLocation)
      dogLocation = Location(dogLocation.lat - 0.00001, dogLocation.lng + 0.00002)
      delay(1000)
    }
  }

  // Lets this simulating run for 15 seconds
  delay(15_000)
  System.exit(0)
}
