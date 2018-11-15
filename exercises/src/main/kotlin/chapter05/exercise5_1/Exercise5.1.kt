package chapter05.exercise5_1

import chapter05.exercise5_1.Exercise5_1.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * The inferred platform types are, in order, the following:
 * 1) Double
 * 2) Int!
 * 3) (Mutable)List<String!>
 * 4) CharArray!
 * 5) Array<(out) Person!>!
 * 6) Any!
 * 7) MutableList<out Comparable<T!>!>!
 * 8) (Mutable)Map<Address, (Mutable)List<Employee!>>!
 */

/*
 * Here are the examples in code to verify. These use the Java class `Exercise5_1`.
 * To see the inferred platform types, let IntelliJ show autocomplete inside the methods and look at the return types.
 */
val average = calculateAverage()   // Double
val age = getAge()                 // Int!
val titles = titles()              // (Mutable)List<String!>
val chars = toCharArray()          // CharArray!
val people = getAttendees()        // Array<(out) Person!>!
val thing = get()                  // Any!
val ratings = fetchRatings<Int>()  // MutableList<out Comparable<T!>!>!
val locationsToEmployees = locationsToEmployees()  // (Mutable)Map<Address, (Mutable)List<Employee!>>!