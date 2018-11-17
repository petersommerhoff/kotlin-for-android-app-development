import kotlin.reflect.KClass
class A
// ---------

private val kclass: KClass<A> = A::class
private val jclass: Class<A> = A::class.java

// ---------
println(kclass)
println(jclass)