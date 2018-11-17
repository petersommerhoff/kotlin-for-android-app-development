package chapter05

private val creator = Producer { Box(9000) }  // Inferred type: Producer<Box>

println(creator.produce().value)  // 9000