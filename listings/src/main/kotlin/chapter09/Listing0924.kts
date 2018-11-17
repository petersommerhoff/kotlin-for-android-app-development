// Android-specific example (Anko)

//class AddTodoActivity : AppCompatActivity() {
//  // …
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(createView())  // Still no inflating of an XML layout
//    viewModel = getViewModel(TodoViewModel::class)
//  }
//
//  private fun createView() = verticalLayout {  // Sets up vertical linear layout
//
//    val etNewTodo = editText {  // Sets up EditText and adds it to the linear layout
//      hintResource = R.string.enter_new_todo
//      textAppearance = android.R.style.TextAppearance_Medium
//    }.lparams(width = matchParent, height = wrapContent) {
//      margin = dip(16)
//    }
//
//    button(R.string.add_to_do) {  // Sets up Button and adds it to the linear layout
//      textAppearance = android.R.style.TextAppearance
//    }.lparams(width = wrapContent, height = wrapContent) {
//      gravity = Gravity.CENTER_HORIZONTAL
//    }.setOnClickListener {        // Could also use onClick inside button {…} instead
//      val newTodo = etNewTodo.text.toString()
//      launch(DB) { viewModel.add(TodoItem(newTodo)) }
//      finish()
//    }
//  }
//}