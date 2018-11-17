
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.CoroutineName
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.ContinuationInterceptor

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
// ------------
launch(name + exceptionHandler) {
  println("Context:           ${coroutineContext}")
  println("Job:               ${coroutineContext[Job]}")
  println("Dispatcher:        ${coroutineContext[ContinuationInterceptor]}")
  println("Name:              ${coroutineContext[CoroutineName]}")
  println("Exception Handler: ${coroutineContext[CoroutineExceptionHandler]}")
}
