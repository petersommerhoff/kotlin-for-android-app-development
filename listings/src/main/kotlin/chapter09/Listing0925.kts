// Android-specific example (Anko)

//class AddTodoActivity : AppCompatActivity() {
//  // …
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(AddTodoActivityUi().createView(AnkoContext.create(ctx, this)))
//    viewModel = getViewModel(TodoViewModel::class)
//  }
//
//  private inner class AddTodoActivityUi : AnkoComponent<AddTodoActivity> {
//
//    override fun createView(ui: AnkoContext<AddTodoActivity>): View = with(ui) {
//
//      verticalLayout {
//        val etNewTodo = editText {
//          hintResource = R.string.enter_new_todo
//          textAppearance = android.R.style.TextAppearance_Medium
//        }.lparams(width = matchParent, height = wrapContent) {
//          margin = dip(16)
//        }
//
//        button(R.string.add_to_do) {
//          textAppearance = android.R.style.TextAppearance
//        }.lparams(width = wrapContent, height = wrapContent) {
//          gravity = Gravity.CENTER_HORIZONTAL
//        }.setOnClickListener {
//          val newTodo = etNewTodo.text.toString()
//          launch(DB) { viewModel.add(TodoItem(newTodo)) }
//          finish()
//        }
//      }
//    }
//  }
//}