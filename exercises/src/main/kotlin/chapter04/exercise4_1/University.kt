package chapter04.exercise4_1

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
class University(val name: String, val foundingYear: Int) {

  val professors = mutableListOf<Professor>()
  val students = mutableListOf<Student>()

  fun hire(prof: Professor) {
    professors.add(prof)
    println("Hired Professor ${prof.name} at $name...")
  }

  fun enroll(newStudent: Student) {
    students.add(newStudent)
    println("Enrolled student ${newStudent.name} at $name...")
  }
}