package chapter05.exercise5_4

import javafx.scene.control.Button
import java.math.BigDecimal

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * Generates no static members.
 */
class Constants1 {
  @JvmField val PI = BigDecimal(3.1415926535897932384626433)
}

/*
 * Generates a static method due to @JvmStatic.
 * Additional static INSTANCE generated for Singleton pattern
 */
object MainPresenter {
  fun notifyUser(message: String) {}
}

/*
 * Generates a private static member for `defaultRobot` but the public getter for it is not static.
 * Additional static member INSTANCE generated for Singleton pattern.
 */
object RobotFactory {
  val defaultRobot = Robot()
}

/*
 * Generates a static field PI.
 * Additional static INSTANCE generated for Singleton pattern
 */
object Constants2 {
  const val PI = 3.14159265358979323
}

/*
 * Generates a static nested class PersonBuilder.
 * The companion object methods are not static.
 */
class Person {
  companion object PersonBuilder {
    fun build(): Person = Person()
  }
}

/*
 * Generates no static members.
 */
class MainUi {
  lateinit var btnOk: Button
}




// -----------
class Robot