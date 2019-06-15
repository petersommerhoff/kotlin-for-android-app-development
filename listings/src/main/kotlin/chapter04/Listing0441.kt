sealed class Expr  // Sealed class representing possible arithmetic expressions
data class Const (val value: Int) : Expr()
data class Plus  (val left: Expr, val right: Expr) : Expr()
data class Minus (val left: Expr, val right: Expr) : Expr()
data class Times (val left: Expr, val right: Expr) : Expr()
data class Divide(val left: Expr, val right: Expr) : Expr()

fun evaluate(expr: Expr): Double = when(expr) {
  is Const  -> expr.value.toDouble()
  is Plus   -> evaluate(expr.left) + evaluate(expr.right)
  is Minus  -> evaluate(expr.left) - evaluate(expr.right)
  is Times  -> evaluate(expr.left) * evaluate(expr.right)
  is Divide -> evaluate(expr.left) / evaluate(expr.right)
}  // No else-branch required: all possible cases are handled

val formula: Expr = Times(Plus(Const(2), Const(4)), Minus(Const(8), Const(1)))

// ------- (need main here)
fun main() {
  println(evaluate(formula))  // 42.0
}

