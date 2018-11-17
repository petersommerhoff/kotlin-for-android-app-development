package chapter05

// Declarations are renamed to avoid name clashes with previous listing file

fun consumeStack0529(stack: Stack<@JvmSuppressWildcards Number>) { } // No more wildcards

// Normally no wildcards are generated for return types, unless you use @JvmWildcard
fun produceStack0529(): Stack<@JvmWildcard Number> {
  return Stack(4, 8, 15, 16, 23, 42)
}

