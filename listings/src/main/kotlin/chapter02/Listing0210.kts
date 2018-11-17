val maxSurfaceTempInK = 700

val temperatureDescription = when (maxSurfaceTempInK) {
  700 -> "This is Mercury’s maximum surface temperature"
  // ...
  else -> {
    // more code...
    "Default case"
  }
}

println(temperatureDescription)