val string = "This is an example sentence with several words in it"
val lengthToWords = string.split(" ")  // ["This", "is", "an", …, "in", "it"]
    .groupBy { it.length }

println(lengthToWords)  // {4=[This, with], 2=[is, an, in, it], … }
