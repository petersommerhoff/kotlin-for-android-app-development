package chapter06

sealed class Transaction
data class Deposit(val amount: Int) : Transaction()
data class Withdrawal(val amount: Int) : Transaction()