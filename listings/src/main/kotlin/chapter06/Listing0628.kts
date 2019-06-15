import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

GlobalScope.launch { println("Running on ${Thread.currentThread().name}") }
CoroutineScope(Dispatchers.IO).launch { println("Running on ${Thread.currentThread().name}") }
CoroutineScope(Dispatchers.Default).launch { println("Running on ${Thread.currentThread().name}") }
