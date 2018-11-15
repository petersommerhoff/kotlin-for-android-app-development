package chapter04.exercise4_4

import kotlin.math.max

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
abstract class GameCharacter(val name: String, var healthPoints: Int, var attackPoints: Int, var defensePoints: Int) {

  fun attack(other: GameCharacter) {
    val damage = max(0, this.attackPoints - other.defensePoints)
    other.healthPoints = max(0, other.healthPoints - damage)
    println("> ${this.name} made $damage damage to ${other.name} (${other.name} has ${other.healthPoints} HP left)")
  }

  fun isDead() = healthPoints <= 0

  fun heal(hp: Int) {
    this.healthPoints += hp  // There's no maximum for HP
    println("> ${this.name} healed $hp HP (now has ${this.healthPoints} HP)")
  }
}