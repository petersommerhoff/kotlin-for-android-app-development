class Box<T>(elem: T) {  // Generic class: can be a box of integers, box of strings, …
  val element: T = elem
}

val box: Box<Int> = Box(17)  // Type Box<Int> can also be inferred
println(box.element)         // 17
