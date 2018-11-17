val elements = listOf(4, 5.6, "hello", 6, "hi", null, 1)
// ---------------

elements.filter { it is Int }.map { it as Int? }  // Inlined function and inserted T