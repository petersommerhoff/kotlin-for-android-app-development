package chapter04.exercise4_1

import kotlin.math.max
import kotlin.math.min

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
class Student(
    val name: String,
    val age: Int,
    val matriculationNo: Int
) {

  val grades = mutableMapOf<Course, Grade>()
  val currentEnrollments = mutableListOf<Course>()

  private var successLikelihoodInPercent: Int = 50

  fun enroll(course: Course) {
    currentEnrollments.add(course)
    println("$name enrolled in ${course.title}...")
  }

  fun takeExam(course: Course) {
    println("$name takes exam in ${course.title}...")
  }

  fun learn() {
    println("$name is learning...")
    successLikelihoodInPercent = min(successLikelihoodInPercent + 2, 100)
  }

  fun party() {
    println("$name is partying! \uD83C\uDF89")
    successLikelihoodInPercent = max(successLikelihoodInPercent - 2, 0)
  }

  fun grade(course: Course, grade: Grade) {
    grades[course] = grade
  }
}