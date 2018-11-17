import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.CoroutineName
import kotlinx.coroutines.experimental.launch

// CoroutineName
val name = CoroutineName("Koroutine")

launch(name) { }

// CoroutineExceptionHandler
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}

launch(exceptionHandler) { }
