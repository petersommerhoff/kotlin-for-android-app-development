package chapter04.exercise4_1

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
class Professor(val name: String, val age: Int, val yearlySalary: Int) {

  val coursesTaught = mutableListOf<Course>()

  fun teach(course: Course) {
    coursesTaught.add(course)
    println("Teaching ${course.title}...")
  }

  fun doOralExam(student: Student, course: Course) {
    println("Testing student ${student.name} in ${course.title}")
    student.grade(course, Grade.A)  // Everyone gets an A
  }
}