class ReturnsObjectExpressions {
  fun prop() = object {                         // Returns an object; infers Any type
    val prop = "Not accessible"
  }

  fun propWithInterface() = object : HasProp {  // Returns an object; infers HasProp
    override val prop = "Accessible"
  }

  fun access() {
//    prop().prop               // Compile-time error (Any does not have prop)
    propWithInterface().prop  // Now possible (HasProp has prop)
  }
}

interface HasProp {  // Allows exposing the ‘prop’ to the outside
  val prop: String
}
