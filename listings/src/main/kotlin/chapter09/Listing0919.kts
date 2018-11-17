// Android-specific example

//class AddTodoActivity : AppCompatActivity() {
//  // …
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(createView())  // No inflating of an XML layout
//    viewModel = getViewModel(TodoViewModel::class)
//  }
//
//  private fun createView(): View {
//    val linearLayout = LinearLayout(this).apply {  // Sets up the linear layout
//      orientation = LinearLayout.VERTICAL
//    }
//    val etNewTodo = EditText(this).apply {  // Sets up the EditText
//      hint = getString(R.string.enter_new_todo)
//      textAppearance = android.R.style.TextAppearance_Medium
//      layoutParams = ViewGroup.LayoutParams(
//          ViewGroup.LayoutParams.MATCH_PARENT,
//          ViewGroup.LayoutParams.WRAP_CONTENT
//      )
//    }
//    val btnAddTodo = Button(this).apply {  // Sets up the Button
//      text = getString(R.string.add_to_do)
//      textAppearance = android.R.style.TextAppearance
//      layoutParams = LinearLayout.LayoutParams(
//          ViewGroup.LayoutParams.WRAP_CONTENT,
//          ViewGroup.LayoutParams.WRAP_CONTENT
//      ).apply { gravity = Gravity.CENTER_HORIZONTAL }
//      setOnClickListener {
//        val newTodo = etNewTodo.text.toString()
//        launch(DB) { viewModel.add(TodoItem(newTodo)) }
//        finish()
//      }
//    }
//    return linearLayout.apply {  // Adds views to the linear layout and returns it
//      addView(etNewTodo)
//      addView(btnAddTodo)
//    }
//  }
//}