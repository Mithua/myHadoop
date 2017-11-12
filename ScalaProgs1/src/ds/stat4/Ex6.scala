package ds.stat4

/*
 * This example shows the richness of the traits, which could be completely
 * invisible to  implementing classes and objects!
 */
trait Logger6 {
	def log(msg: String)
	def info(msg: String) { log("INFO: " + msg) }
	def warn(msg: String) { log("WARN: " + msg) }
	def fatal(msg: String) { log("BREACH: " + msg) }
}

class Account6 {
	protected var balance = 0.0
}

class SavingsAccount6 extends Account6 with Logger6 {
	def withdraw(amount: Double) {
		if (amount > balance) fatal("Insufficient funds")
		else balance -= amount
	}

	// More methods ...

	override def log(msg: String) { println(msg) }
}

object Main6 extends App {
	val acct1 = new SavingsAccount6
			acct1.withdraw(100) 
}

