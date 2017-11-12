package ds.stat4

// These are meant to be typed into the REPL. You can also run
// scala -Xnojline < repl-session.scala to run them all at once.

class Counter1 {
	private var value = 0 // You must initialize the field
	def increment() { value += 1 } // Methods are public by default
	def current() = value
}

object Main1 extends App {
	    val myCounter = new Counter1
			myCounter.increment()
			println(myCounter.current)

			/*	val myCounter1 = new Counter1() // () ok
	myCounter.current()*/ // () ok
}

/*class Counter2 {
	private var value = 0 
			def increment() { value += 1 } 
	def current = value // No () in definition
}*/

/*object Main2 extends App {
val myCounter = new Counter2
myCounter.current // () not ok

println(myCounter.current)

}*/