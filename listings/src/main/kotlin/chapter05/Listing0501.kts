import com.google.common.math.Stats
import java.util.*

// Using the standard library
val arrayList = ArrayList<String>()  // Uses java.util.ArrayList
arrayList.addAll(arrayOf("Mercury", "Venus", "Jupiter"))
arrayList[2] = arrayList[0]          // Indexed access operator calls ‘get’ and ‘set’

// Looping as usual, ArrayList provides iterator()
for (item in arrayList) { println(item) }

// Using a third-party library (Google Guava)
val stats = Stats.of(4, 8, 15, 16, 23, 42)
println(stats.sum())  // 108
