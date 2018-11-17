import java.util.*

fun Date.plusDays(n: Int) = Date(this.time + n * 86400000)
val now = Date()
val tomorrow = now.plusDays(1)

println(now)
println(tomorrow)