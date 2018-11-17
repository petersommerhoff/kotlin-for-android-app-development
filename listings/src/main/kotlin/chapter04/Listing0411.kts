import java.time.LocalDate
import kotlin.properties.Delegates

class Cat(private val birthday: LocalDate) {
  // …
  var mood: Mood by Delegates.observable(Mood.GRUMPY) {  // Observable property
    property, oldValue, newValue ->  // Lambda parameters with old and new value

    println("${property.name} change: $oldValue -> $newValue")

    when (newValue) {
      Mood.HUNGRY -> println("Time to feed the cat…")
      Mood.SLEEPY -> println("Time to rest…")
      Mood.GRUMPY -> println("All as always")
    }
  }
}

enum class Mood { GRUMPY, HUNGRY, SLEEPY }  // Enums are explained later

val felix = Cat(LocalDate.of(2013, 11, 27))
felix.mood = Mood.HUNGRY  // "mood change: GRUMPY -> HUNGRY\n Time to feed the cat…"
felix.mood = Mood.SLEEPY  // "mood change: HUNGRY -> ASLEEP\n Time to rest…"
felix.mood = Mood.GRUMPY  // "mood change: ASLEEP -> GRUMPY\n All as always"
