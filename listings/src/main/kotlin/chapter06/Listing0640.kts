import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// CoroutineName
val name = CoroutineName("Koroutine")

CoroutineScope(name).launch { }

// CoroutineExceptionHandler
val exceptionHandler = CoroutineExceptionHandler { context, exception ->
  println("Crashed with context $context")
  exception.printStackTrace()
}

CoroutineScope(exceptionHandler).launch { }
