package chapter05

sealed class Component
data class Composite(val children: List<Component>) : Component()
data class Leaf(val value: Int): Component()
