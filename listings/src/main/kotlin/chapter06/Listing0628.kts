import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.launch

launch { println("Running on ${Thread.currentThread().name}") }
launch(DefaultDispatcher) { println("Running on ${Thread.currentThread().name}") }
launch(CommonPool) { println("Running on ${Thread.currentThread().name}") }
