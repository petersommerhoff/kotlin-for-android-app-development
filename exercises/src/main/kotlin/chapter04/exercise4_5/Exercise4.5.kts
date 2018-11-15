package chapter04.exercise4_5

import kotlin.properties.Delegates

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * 1) A test class’ property that is re-initialized before each test case
 *
 * -> This is a typical use case for a lateinit property because a framework or separate entity (here the test runner)
 *    is responsible for initializing it.
 */
class Person(var age: Int) {
  fun birthday() { age++ }
}

annotation class BeforeEach  // Let's imagine this comes from JUnit

class SomeTest {

  lateinit var person: Person

  @BeforeEach  // In a JUnit test case, this would automatically run before each test case
  fun setup() {
    person = Person(20)
  }

  fun birthdayShouldIncreaseAgeByOne() {
    // when
    val ageBefore = person.age

    // given
    person.birthday()

    // then
    // (misusing Kotlin's `assert` as test case asserter for this example...)
    assert(person.age == ageBefore + 1) { "Age should increase by 1 on birthday." }
  }
}

/*
 * 2) Validating property changes and rejecting invalid changes
 *
 * -> Observing property changes is possible with delegated properties, both `observable` and `vetoable`. To be able to
 *    reject invalid changes, you must use `vetoable`
 */
class Cat {
  var name by Delegates.vetoable("Oscar") { property, oldName, newName ->
    newName.isNotBlank()  // Reject blank names
  }
}

val oscar = Cat()
oscar.name = "  "
println(oscar.name)

/*
 * 3) Properties holding UI components that can only be initialized once the necessary context is ready
 *
 * -> This is another use case for lateinit which allows declaring all desired properties at the top of the class and
 *    initializing them once the necessary context is created. Note that there is no external framework that's
 *    responsible for the initialization here so take care to perform all initializations before use.
 */
open class ViewModel
class MyViewModel : ViewModel()

class ViewModels {
  companion object {
    fun <T : ViewModel> get(viewModel: Class<T>) = MyViewModel()
  }
}

class SomeActivity {  // Let's imagine this was an Android activity
  lateinit var someViewModel: MyViewModel  // Cannot be initialized yet

  fun onCreate() {  // On Android, this would be a lifecycle method
    someViewModel = ViewModels.get(MyViewModel::class.java)
  }
}

/*
 * 4) Expensive objects that may not be used at runtime because they are not used on all execution paths
 *
 * -> To initialize (expensive) objects only if and when it becomes necessary, you can use a `lazy` delegated property
 */
class Database

class AnotherActivity {
  val db: Database by lazy { buildExpensiveDatabaseObject() }

  fun buildExpensiveDatabaseObject() = Database()  // Let's imagine this was an expensive object creation
}