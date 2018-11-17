fun twice(f: (Int) -> Int): (Int) -> Int = { x -> f(f(x)) }  // Applies ‘f’ twice
// ---------

val plusTwo = twice({ it + 1 })  // Uses lambda
val plus2   = twice(Int::inc)    // Uses function reference
