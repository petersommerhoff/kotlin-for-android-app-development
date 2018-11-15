package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

val parentsToChildren = mapOf(
    "Susan" to listOf("Kevin", "Katie"),
    "Marcus" to listOf("Claire"),
    "Kate" to emptyList(),
    "Mike" to listOf("Jake", "Helen", "John")
)

val result = parentsToChildren.filter { it.value.isNotEmpty() }
    .filter { it.key.toUpperCase().startsWith("M") }
    .map { "${it.key}'s children are ${it.value.joinToString(" and ")}" }

println(result)