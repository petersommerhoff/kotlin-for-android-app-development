package chapter03

import java.awt.Dimension
import java.awt.Font
import javax.swing.JButton

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// 1) Initializing an object (that requires additional initialization after the constructor call)
// -> This is the ideal use case for `apply`
val button = JButton("OK").apply {
  size = Dimension(200, 60)
  font = Font.getFont("Segoe UI")
  addActionListener { }
}

// 2) Calling many methods on the same variable
// -> This is the most common use case for `with` (which returns the value in the last line)
// Note: You could use `apply` here as well but we use it rather for object initialization and
// prefer `with` for using builders and returning the built value
val question = with(StringBuilder()) {
  append("Are you ")
  append(button.text)
  append("?")
  toString()
}

// 3) Performing a block of code only if a given variable is not null
// -> The most typical use case for calling `let` with a safe call
val font: Font? = button.font
font?.let {
  println(it.fontName)
}

// 4) Immediate function application (directly running a given lambda expression)
// -> This can be achieved most easily using `run`
run {
  val scoped = "Invisible to the outside"
  println(scoped)
}

// 5) Intercepting a function chain for ancillary operations, such as logging, without breaking the
// function chain
// -> We use `also` for ancillary operations like this
val vowelCount = question.filter { it in listOf('a', 'e', 'i', 'o', 'u') }
    .also { println("Found vowels: $it") }
    .count()

// 6) Transforming an explicit parameter to a receiver object
// -> This is achieved using `run` on the parameter, e.g., to avoid repeating long variable names
fun validateCredentials(userCredentialsToValidate: Credentials) = userCredentialsToValidate.run {
  // `this.name`, or just `name`, now refers to the name property of the credentials object
  name.isNotBlank()
  password.length >= 8
}


class Credentials(val name: String, val password: String)