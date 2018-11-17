fun areaOfEllipse(vertex: Double, covertex: Double): Double {
  val ellipse = object {  // Ad-hoc object
    val x = vertex
    val y = covertex
  }
  return Math.PI * ellipse.x * ellipse.y
}
