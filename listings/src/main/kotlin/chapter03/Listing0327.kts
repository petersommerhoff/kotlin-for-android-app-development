val words = listOf("filter", "map", "sorted", "groupBy", "associate")
var id = 0                                // The first map key
val map = words.associate { id++ to it }  // Associates incrementing keys to ele-ments
println(map)  // {0=filter, 1=map, 2=sorted, 3=groupBy, 4=associate}
