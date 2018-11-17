import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Cat(val birthday: LocalDate) {
  val age: Int by lazy {  // Lazy property, computed on demand only if necessary
    println("Computing age...")
    ChronoUnit.YEARS.between(birthday, LocalDate.now()).toInt()  // Computes age
  }
}

val felix = Cat(LocalDate.of(2013, 10, 27))
println("age = ${felix.age}")  // "Computing age...\n age = 5" (run in 2018)
println("age = ${felix.age}")  // "age = 5"; returns cached value
