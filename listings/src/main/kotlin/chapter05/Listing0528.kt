package chapter05

class Stack<out E>(vararg items: E) { }
fun consumeStack(stack: Stack<Number>) { }
