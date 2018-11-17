class Task(val title: String, var priority: Int) {  // Parameters are now properties
  init {
    require(priority >= 0)                    // Uses property in init-block
  }
}
