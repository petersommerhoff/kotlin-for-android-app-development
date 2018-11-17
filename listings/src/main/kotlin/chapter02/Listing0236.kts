val negativeZero = -0.0f              // Statically inferred type: Float
val positiveZero = 0.0f               // Statically inferred type: Float
println(Float.NaN == Float.NaN)       // false (IEEE standard)
println(negativeZero == positiveZero) // true (IEEE standard)

val nan: Any = Float.NaN          // Explicit type: Any => not Float or Double
val negativeZeroAny: Any = -0.0f  // Explicit type: Any
val positiveZeroAny: Any = 0.0f   // Explicit type: Any

println(nan == nan)                          // true (not IEEE standard)
println(negativeZeroAny == positiveZeroAny)  // false (not IEEE standard)
