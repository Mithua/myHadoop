package ds.stat4

abstract class Person20(val name: String) {
	def id: Int // No method body�this is an abstract method
}

class Employee20(name: String) extends Person20(name) {
	def id = name.hashCode // override keyword not required
}

object Main20 extends App {
	val fred = new Employee20("Santosh")
	println(fred.id)
}