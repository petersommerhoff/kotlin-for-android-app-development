val maxSurfaceTempInK = 700
fun earthSurfaceTemp(): Int = 273 + 20

when (maxSurfaceTempInK) {
  700                 -> println("This is Mercury’s maximum surface temperature.")
  0, 1, 2             -> println("It’s as cold as it gets.")
  in 300..699         -> println("This temperature is also possible on Mercury.")
  !in 0..300          -> println("This is pretty hot.")
  earthSurfaceTemp()  -> println("This is earth’s average surface temperature.")
  is Int              -> println("Given variable is of type Int.")
  else                -> {
    // more code...
    println("Default case")
  }
}
