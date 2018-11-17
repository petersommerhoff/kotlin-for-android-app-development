class Closed                        // Closed class: cannot inherit from this
//class ChildOfClosed : Closed()      // NOT allowed: compile-time error

open class Open                     // Open class: can inherit
class ChildOfOpen : Open()          // Allowed
//class ChildOfChild : ChildOfOpen()  // NOT allowed: compile-time error
