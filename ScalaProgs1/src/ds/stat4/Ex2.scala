package ds.stat4

trait ConsoleLogger2 {
  def log(msg: String) { println(msg) }
}

class Account2 {
  protected var balance = 10.0
}

class SavingsAccount extends Account2 with ConsoleLogger2 {
//class SavingsAccount extends ConsoleLogger2  with Account2{
  def withdraw(amount: Double) {
    if (amount > balance) log("Oops..! You don't have enough balance!!")
    else balance -= amount
  }

  // More methods ...
}

object Main2 extends App {
  val acct = new SavingsAccount
  acct.withdraw(100)
}