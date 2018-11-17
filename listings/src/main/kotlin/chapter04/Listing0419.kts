class Task(_title: String, _priority: Int) {  // Defines regular parameters
  val title = _title.capitalize()             // Uses parameter in initializer
  var priority: Int

  init {
    priority = Math.max(_priority, 0)         // Uses parameter in init-block
  }
}
