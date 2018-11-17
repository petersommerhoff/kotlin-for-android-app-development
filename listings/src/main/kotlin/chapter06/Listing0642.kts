import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.CoroutineName
import kotlinx.coroutines.experimental.NonCancellable
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

val name = CoroutineName("Koroutine")
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}
val contextJob = NonCancellable
// -----------------

// CoroutineName + CoroutineExceptionHandler
launch(name + exceptionHandler) { }

// Job + CoroutineDispatcher
launch(contextJob + UI) { }
