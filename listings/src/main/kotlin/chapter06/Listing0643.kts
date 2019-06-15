import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
// ------------
CoroutineScope(name + exceptionHandler).launch {
  println("Context:           ${coroutineContext}")
  println("Job:               ${coroutineContext[Job]}")
  println("Dispatcher:        ${coroutineContext[ContinuationInterceptor]}")
  println("Name:              ${coroutineContext[CoroutineName]}")
  println("Exception Handler: ${coroutineContext[CoroutineExceptionHandler]}")
}
