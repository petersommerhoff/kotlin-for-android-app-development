interface Compare<in T> {       // ‘in’ indicates contravariance
  fun compare(a: T, b: T): Int  // T is only used at in-position
}
