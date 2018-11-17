class Container {
  fun Int.foo() {                       // Extends Int with a ‘foo’ method
    println(toString())                 // Calls Int.toString (like this.toString())
    println(this@Container.toString())  // Calls Container.toString
  }

  fun bar() = 17.foo()                  // Uses extension method
}

Container().bar()                       // "17\n Container@33833882"
