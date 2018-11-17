class SqlQuery() {
  fun append(query: String) {}
  fun bind(value: Any) {}
}
class DbConnection() {
  fun execute(query: SqlQuery) {}
}
// ------------

val sql = SqlQuery().apply {  // ‘apply’ initializes object
  append("INSERT INTO user (username, age, paid) VALUES (?, ?, ?)")
  bind("petersommerhoff")
  bind(26)
  bind(true)
}.also {
  println("Initialized SQL query: $it")  // ‘also’ intercepts computation chain
}.run {
  DbConnection().execute(this)           // ‘run’ applies given operations
}
