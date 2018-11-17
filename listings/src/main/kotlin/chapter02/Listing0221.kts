fun exploreDirectory(path: String, depth: Int = 0) {}

val directory = "/home/johndoe/pictures"

exploreDirectory(directory)                    // Without optional argument, depth is 0
exploreDirectory(directory, 1)           // Recursion depth set to 1
exploreDirectory(directory, depth = 2)         // Uses named parameter to set depth
exploreDirectory(depth = 3, path = directory)  // Uses named parameters to change order
