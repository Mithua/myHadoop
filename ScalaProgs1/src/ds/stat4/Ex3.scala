package ds.stat4

/*
 * This code example shows creation of two different objects
 * of same class, but every time extending different traits
 */
trait ConcreteLogged3 {
	def log(msg: String) { }
}

trait ConsoleLogger3 extends ConcreteLogged3 {
	override def log(msg: String) { println(msg) }
}

class Account3 {
	protected var balance = 0.0
}

class SavingsAccount3 extends Account3 with ConcreteLogged3 {
	def withdraw(amount: Double) {
		if (amount > balance) log("Insufficient funds")
		else balance -= amount
	}

	// More methods ...
}

object Main3 extends App {
	val acct1 = new SavingsAccount3
			acct1.withdraw(100) // No log message is printed

		println("Overdrawing acct2");
	val acct2 = new SavingsAccount3 with ConsoleLogger3
			acct2.withdraw(100)
}

