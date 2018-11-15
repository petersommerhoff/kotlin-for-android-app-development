package chapter04.exercise4_1

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

fun main(args: Array<String>) {
  val rwth = University("RWTH Aachen University", 1870)
  val professor = Professor("John Doe", 44, 90_000)
  val student = Student("Sarah Keller", 22, 123456)
  val course = Course(
      "Programming I",
      "Learn object-oriented, functional, and logical programming"
  )

  rwth.hire(professor)
  rwth.enroll(student)
  professor.teach(course)
  student.enroll(course)
  student.party()
  student.party()
  student.party()
  student.learn()
  student.takeExam(course)
  professor.doOralExam(student, course)
}