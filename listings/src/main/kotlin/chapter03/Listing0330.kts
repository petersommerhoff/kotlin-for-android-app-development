val testData = arrayOf(0, 1, 5, 9, 10)
val sum = testData.fold(0) { acc, element -> acc + element }      // 25
val product = testData.fold(1) { acc, element -> acc * element }  // 0

println(sum)
println(product)