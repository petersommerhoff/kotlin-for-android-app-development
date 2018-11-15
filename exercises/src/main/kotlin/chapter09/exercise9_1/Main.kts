package chapter09.exercise9_1

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * There are a million different ways to design this DSL. One extremely useful feature here is to have extension
 * properties for the units (such as mg and g) and infix function `of` that allows the code to read almost like a recipe.
 *
 * There are certainly many ways to flesh this DSL out further, and I encourage you to do so if you want to gather more
 * experience building DSLs in Kotlin.
 */

val bananaBreadRecipe = recipe("Banana & Walnut Bread") {

  description = "A healthy & tasty banana and walnut bread"

  add(2.pc of "Ripe banana")
  add(125.ml of "Milk (any kind)")
  add(10.ml of "Lemon juice")

  add(200.g of "All-purpose flour")
  add(100.g of "Whole wheat flour")
  add(100.g of "Brown sugar")
  add(1.pack of "Baking powder")
  add(2.g of "Salt")
  add(20.g of "Flaxseeds")
  add(100.g of "Walnuts")

  instructions = """Mash bananas and mix with rest of wet ingredients. Mix all dry ingredients and stir into
      wet ingredients until you get a (quite wet) dough. Put into baking form, sprinkle water on top,
      and bake for 45min at 175°C. Cut a line into the top of the bread after around 5min of baking."""
}

println(bananaBreadRecipe)