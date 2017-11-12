package ds.stat4

//This example shows overriding abstract method of a trait in another trait
//Example 1 was showing overriding of an abstract method in a CLASS 
trait Logger5 {
	def log(msg: String) // This method is abstract
}

trait TimestampLogger5 extends Logger5 {
	abstract override def log(msg: String) {
		super.log(new java.util.Date() + " " + msg)
	}
}

trait ConsoleLogger5 extends Logger5 {
	override def log(msg: String) { println(msg) }
}

class Account5 {
	protected var balance = 0.0
}

abstract class SavingsAccount5 extends Account5 with Logger5 {
	def withdraw(amount: Double) {
		if (amount > balance) log("No Funds at all...!!")
		else balance -= amount
	}

	// More methods ...
}

object Main5 extends App {
	val acct1 = new SavingsAccount5 with ConsoleLogger5 with
			TimestampLogger5
			acct1.withdraw(980) 
}