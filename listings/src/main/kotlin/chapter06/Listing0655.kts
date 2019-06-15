import chapter06.Deposit
import chapter06.Transaction
import chapter06.Withdrawal
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking

fun newAccount(startBalance: Int) = GlobalScope.actor<Transaction>(capacity = 10) {
  var balance = startBalance
  for (tx in channel) {
    when (tx) {
      is Deposit -> { balance += tx.amount; println("New balance: $balance") }
      is Withdrawal -> { balance -= tx.amount; println("New balance: $balance") }
    }
  }
}

runBlocking<Unit> {
  val bankAccount = newAccount(1000)
  bankAccount.send(Deposit(500))
  bankAccount.send(Withdrawal(1700))
  bankAccount.send(Deposit(4400))
}
