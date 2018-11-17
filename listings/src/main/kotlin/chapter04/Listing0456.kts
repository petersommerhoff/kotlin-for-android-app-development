import java.time.LocalDate
import java.time.temporal.ChronoUnit

abstract class Human(val birthday: LocalDate) {
  abstract fun age(): Number  // Specifies that method returns a Number
}

class Student(birthday: LocalDate) : Human(birthday) {
  // Return types allow variance so that Int can be used in place of Number
  override fun age(): Int = ChronoUnit.YEARS.between(birthday, LocalDate.now()).toInt()
}
