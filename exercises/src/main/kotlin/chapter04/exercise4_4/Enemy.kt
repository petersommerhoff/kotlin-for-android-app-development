package chapter04.exercise4_4

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
abstract class Enemy(name: String, hp: Int, attackPoints: Int, defensePoints: Int, val experiencePoints: Int)
  : GameCharacter(name, hp, attackPoints, defensePoints)