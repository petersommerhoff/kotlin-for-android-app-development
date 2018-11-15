package chapter04.exercise4_4

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
abstract class Hero(
    name: String,
    hp: Int,
    attackPoints: Int,
    defensePoints: Int,
    var hasSword: Boolean = false,
    var hasArmor: Boolean = false,
    var experiencePointsEarned: Int = 0
) : GameCharacter(name, hp, attackPoints, defensePoints) {

  private val swordAttackBonus = 6
  private val armorDefenseBonus = 2

  fun equipSword() {
    if (hasSword) return

    attackPoints += swordAttackBonus
    hasSword = true
    println("> You found a sword! You now have ${this.attackPoints} ATK!")
  }

  fun equipArmor() {
    if (hasArmor) return

    defensePoints += armorDefenseBonus
    hasArmor = true
    println("> You found an armor! You now have ${this.defensePoints} DEF!")
  }

  fun fight(enemy: Enemy) {
    while (this.healthPoints > 0 && enemy.healthPoints > 0) {
      attack(enemy)
      if (!enemy.isDead()) {
        enemy.attack(this)
      }
    }
    if (!isDead()) {
      experiencePointsEarned += enemy.experiencePoints
    }
  }
}