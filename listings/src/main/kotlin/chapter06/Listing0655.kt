import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.runBlocking

sealed class Transaction
data class Deposit(val amount: Int) : Transaction()
data class Withdrawal(val amount: Int) : Transaction()

fun newAccount(startBalance: Int) = actor<Transaction>(capacity = 10) {
  var balance = startBalance
  for (tx in channel) {
    when (tx) {
      is Deposit -> { balance += tx.amount; println("New balance: $balance") }
      is Withdrawal -> { balance -= tx.amount; println("New balance: $balance") }
    }
  }
}

fun main(args: Array<String>) = runBlocking<Unit> {
  val bankAccount = newAccount(1000)
  bankAccount.send(Deposit(500))
  bankAccount.send(Withdrawal(1700))
  bankAccount.send(Deposit(4400))
}
