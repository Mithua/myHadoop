package ds.stat4

/*
 * This example shows the usage of concrete fields in traits.
 * Here maxLength is the concrete field used in ConsoleLogger7 trait
 */
trait Logged7 {
	def log(msg: String) { }
}

trait ConsoleLogger7 extends Logged7 {
	override def log(msg: String) { println(msg) }
}

trait ShortLogger7 extends Logged7 {
	val maxLength = 15 
			override def log(msg: String) {
		super.log(
				if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
	}
}

class Account7 {
	protected var balance = 0.0
}

class SavingsAccount7 extends Account7 with ConsoleLogger7 with ShortLogger7 {
	var interest = 0.0
			def withdraw(amount: Double) {
		if (amount > balance) log("Near Bankruptcy..!")
		else balance -= amount
	}

	// More methods ...
}

object Main7 extends App {
	val acct = new SavingsAccount7
			acct.withdraw(100)
}