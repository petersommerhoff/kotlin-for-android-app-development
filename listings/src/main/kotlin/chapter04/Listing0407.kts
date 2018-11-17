annotation class BeforeEach
class Car
class TestFactory {
  companion object { fun car(): Car = Car() }
}
// -----------------

class CarTest {
  lateinit var car: Car      // No initialization required here, must use ‘var’

  @BeforeEach
  fun setup() {
    car = TestFactory.car()  // Re-initializes property before each test case
  }
  // ...
}
