class User
// ------------

fun user(init: User.() -> Unit) = User().apply(init)