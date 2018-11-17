sealed class Expression  // Sealed class representing possible arithmetic expressions
data class Const (val value: Int) : Expression()
data class Plus  (val left: Expression, val right: Expression) : Expression()
data class Minus (val left: Expression, val right: Expression) : Expression()
data class Times (val left: Expression, val right: Expression) : Expression()
data class Divide(val left: Expression, val right: Expression) : Expression()

fun evaluate(expr: Expression): Double = when(expr) {
  is Const  -> expr.value.toDouble()
  is Plus   -> evaluate(expr.left) + evaluate(expr.right)
  is Minus  -> evaluate(expr.left) - evaluate(expr.right)
  is Times  -> evaluate(expr.left) * evaluate(expr.right)
  is Divide -> evaluate(expr.left) / evaluate(expr.right)
}  // No else-branch required: all possible cases are handled

val formula: Expression = Times(Plus(Const(2), Const(4)), Minus(Const(8), Const(1)))

// ------- (need main here)
fun main(args: Array<String>) {
  println(evaluate(formula))  // 42.0
}

