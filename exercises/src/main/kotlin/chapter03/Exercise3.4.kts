package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

// TODO: explain/reason why

val collection = listOf(0, 1, 3, 5, 7, 8, 9)

// 1) First five elements plus everything *but* the first five elements is again the whole list.
println(collection.take(5) + collection.drop(5) == collection)

// 2) None of the elements in the list are greater than 5 if and only of all are lower or equal to 5.
println(collection.none { it > 5 } == collection.all { it <= 5 })

// 3) Ascending order is exactly descending order reversed.
println(collection.sorted() == collection.sortedDescending().reversed())

// 4) Reducing all elements with + is the same as folding with an additional zero because zero does
// not add to the overall sum.
println(collection.reduce { x, y -> x + y } == collection.fold(0) { x, y -> x + y })

// 5) Filtering for the *same* predicate more than once has no use.
// A function f with this property is called *idempotent*: f(f(x)) = f(x)
// From this it follows that f(f(...(f(x))...) = f(x) by repeated simplification using f(f(x)) = f(x)
val predicate: (Int) -> Boolean = { it > 5 }
println(collection.filter(predicate).filter(predicate) == collection.filter(predicate))

// 6) Taking the first five elements of the first five elements still gives you the first five
// elements. This is another example of an idempotent function (if you pass the same argument).
println(collection.take(5).take(5) == collection.take(5))

// Which of these identities also hold for lists of any type, not just for lists of integers?
// 1) holds for any list
// 2) only works for lists of integers due to the predicates
// 3) holds for any list
// 4) only works for lists of integers due to the 0 argument in fold but the general concept applies
// as long as the operation (here +) is commutative and fold's first argument (here 0) is the
// neutral element w.r.t. to the operation. For example, 1 as initial value and * as operator works.
// 5) holds for any list
// 6) holds for any list