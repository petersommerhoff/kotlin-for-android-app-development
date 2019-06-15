import kotlinx.coroutines.*

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
val contextJob = NonCancellable
// -----------------

// CoroutineName + CoroutineExceptionHandler
GlobalScope.launch(name + exceptionHandler) { }

// Job + CoroutineDispatcher
GlobalScope.launch(contextJob + Dispatchers.Main) { }
