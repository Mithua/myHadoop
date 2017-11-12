package ds.stat4

class Account11 private (val id: Int, initialBalance: Double) {
	private var balance = initialBalance
			def deposit(amount: Double) { balance += amount }
	def description = "Account " + id + " with balance " + balance
}

object Account11 { // The companion object
	def apply(initialBalance: Double) = 
			new Account11(newUniqueNumber(), initialBalance)
	private var lastNumber = 0
	private def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

object DemoApply extends App {
	val acct = Account11(1000.0)
			println(acct.description)
}