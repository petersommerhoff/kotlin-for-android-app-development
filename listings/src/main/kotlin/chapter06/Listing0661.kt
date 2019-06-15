package chapter06

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

suspend fun fetchScore(): Int { return 42 }  // This can hardly be called directly from Java
fun fetchScoreAsync() = GlobalScope.future { fetchScore() }  // This is to be used from Java
