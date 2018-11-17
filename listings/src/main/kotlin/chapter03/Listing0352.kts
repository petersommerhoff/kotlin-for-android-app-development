val naturalNumbers = generateSequence(0) { it + 1 }  // Next element = previous + 1
val integers = generateSequence(0) { if (it > 0) -it else -it + 1 }

println(naturalNumbers.take(10).joinToString())
println(integers.take(10).joinToString())