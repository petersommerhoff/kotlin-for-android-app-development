val list1 = listOf(1, 2, 3)  // List object
val list2 = listOf(1, 2, 3)  // Different list object but with same contents

println(list1 === list2)  // false: the variables reference different objects in memory
println(list1 == list2)   // true: the objects they reference are equal
println(list1 !== list2)  // true: negation of first comparison
println(list1 != list2)   // false: negation of second comparison
