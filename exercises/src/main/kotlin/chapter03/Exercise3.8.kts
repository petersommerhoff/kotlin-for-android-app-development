package chapter03

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

val nutritionData = mapOf(
    "apple" to mapOf(
        "macros" to mapOf("carbs" to 11.4, "protein" to 0.3, "fats" to 0.2),
        "vitamins" to mapOf("vitamin c" to 4.6),
        "minerals" to mapOf("calcium" to null, "zinc" to 0.1)
    ),
    "black beans" to mapOf(
        "macros" to mapOf("carbs" to 15.0, "protein" to 8.9, "fats" to null),
        "vitamins" to mapOf("vitamin c" to 0.0, "vitamin a" to 0.0018),
        "minerals" to mapOf("calcium" to 27.0, "zinc" to 2.1)
    ),
    "walnuts" to mapOf(
        "macros" to mapOf("carbs" to 13.7, "protein" to 15.2, "fats" to 65.2),
        "vitamins" to mapOf("vitamin c" to 1.3, "vitamin a" to 0.006),
        "minerals" to mapOf("calcium" to 98.0, "zinc" to 2.9)
    )
)

// 1) Richest in calcium
val richestInCalcium = nutritionData
    .maxBy { it.value["minerals"]?.get("calcium") ?: -1.0 }?.key ?: "No food found"

println("Richest in calcium: $richestInCalcium")

// 2) Average fat content
val averageFat = nutritionData.filter { it.value["macros"]?.get("fats") != null }
    .mapValues { it.value["macros"]?.get("fats") }
    .values
    .filterNotNull()
    .average()

println("Average fat content: $averageFat")

// 3) Sorted by protein content descending
val proteinSources = nutritionData.entries.sortedByDescending {
  it.value["macros"]?.get("protein") ?: 0.0
}.map { it.key.capitalize() }

println("Best protein sources:")
proteinSources.forEach(::println)

// 4) Grouping by fat content
val groupedByFat = nutritionData.entries.groupBy {
  val fat = it.value["macros"]?.get("fats") ?: 0.0
  if (fat < 5.0) "Low fat" else "High fat"  // Specifies group names
}.mapValues { it.value.map { foodToData -> foodToData.key.capitalize() } }

println("Grouped by fat content: $groupedByFat")