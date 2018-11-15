package chapter04.exercise4_4

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
fun main(args: Array<String>) {

  val hero = Warrior()

  loop@ while (true) {  // Main game loop
    println("> Fight [g]oblin or [o]rc?")
    print("> ")
    val input = readLine()!!.toLowerCase()
    when (input) {
      !in arrayOf("g", "o") -> {
        println("> Please enter 'g' to fight a [g]oblin or 'o' to fight an [o]rc!")
        continue@loop
      }
      "g" -> hero.fight(Goblin())
      "o" -> hero.fight(Orc())
    }

    if (!hero.hasSword && Math.random() < 0.25)
      hero.equipSword()

    if (!hero.hasArmor && Math.random() < 0.15)
      hero.equipArmor()

    if (Math.random() < 0.10)
      hero.heal(10)

    if (hero.isDead()) {
      println(">>> You're dead! You earned ${hero.experiencePointsEarned} XP!")
      break
    } else {
      println("> Status: ${hero.healthPoints} HP left (${hero.attackPoints} ATK, ${hero.defensePoints} DEF)")
    }
  }
}