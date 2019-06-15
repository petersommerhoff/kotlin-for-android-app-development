
import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
// ------------
GlobalScope.launch(name + exceptionHandler) {
  println("Context:           ${coroutineContext}")
  println("Job:               ${coroutineContext[Job]}")
  println("Dispatcher:        ${coroutineContext[ContinuationInterceptor]}")
  println("Name:              ${coroutineContext[CoroutineName]}")
  println("Exception Handler: ${coroutineContext[CoroutineExceptionHandler]}")
}
