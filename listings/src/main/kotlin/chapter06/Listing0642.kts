import kotlinx.coroutines.*

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
val contextJob = NonCancellable
// -----------------

// CoroutineName + CoroutineExceptionHandler
CoroutineScope(name + exceptionHandler).launch { }

// Job + CoroutineDispatcher
CoroutineScope(contextJob + Dispatchers.Main).launch { }
