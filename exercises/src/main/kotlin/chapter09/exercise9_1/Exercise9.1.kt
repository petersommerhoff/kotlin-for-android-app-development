package chapter09.exercise9_1

import chapter09.exercise9_1.Measure.*

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * This is a rather minimal DSL, without any additional nesting. Instead, the `add` function ends up reading like part
 * of a recipe (see [Main.kts]).
 *
 * Note that, with this DSL structure, we don't need a @DslMarker annotation. We could disallow nesting another recipe
 * into a different one by overwriting the function but it might actually be a good way to split a complex recipe up
 * into sub-recipes -- this is one of the issues you'd discuss with your DSL users in reality.
 */

fun recipe(name: String, init: RecipeBuilder.() -> Unit) = RecipeBuilder(name).apply(init).build()

class RecipeBuilder(val recipeName: String) {
  var description: String = ""
  var instructions: String = ""
  private val ingredients: MutableList<Ingredient> = mutableListOf()

  fun add(ingredient: Ingredient) = ingredients.add(ingredient)

  fun build() = when {
    isValid() -> Recipe(recipeName, description, ingredients)
    else -> throw IllegalStateException("Need at least 2 ingredients")
  }

  private fun isValid() = ingredients.size >= 2
}

data class Recipe(
    private val name: String,
    private val description: String,
    private val ingredients: List<Ingredient>
)

data class Ingredient(private val name: String, private val amount: Amount)

data class Amount(private val amount: Number, private val measure: Measure)

// You can use other units that you're used to (cups, oz); note that this list is very incomplete
enum class Measure(val representation: String) {
  GRAMS("g"),
  MILLILITERS("ml"),
  PIECES(" pc"),
  PACK(" pack")
}

infix fun Amount.of(food: String) = Ingredient(food, this)

val Number.g: Amount
  get() = Amount(this, GRAMS)

val Number.ml: Amount
  get() = Amount(this, MILLILITERS)

val Number.pc: Amount
  get() = Amount(this, PIECES)

val Number.pack: Amount
  get() = Amount(this, PACK)
