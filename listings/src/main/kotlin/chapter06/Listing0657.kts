// Use compiler flag: -Dkotlinx.coroutines.debug
fun log(message: String) = println("[${Thread.currentThread().name}] $message")