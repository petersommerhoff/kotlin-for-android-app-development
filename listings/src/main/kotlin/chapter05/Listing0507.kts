import chapter05.Box

val value1 = Box(19)
val value2 = Box(37)
val value3 = Box(14)

val result = value1 + value2 - value3  // Uses ‘plus’ and ‘minus’ as operators
println(result.value)  // 42
