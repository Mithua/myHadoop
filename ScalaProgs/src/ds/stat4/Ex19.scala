package ds.stat4

class Person19(val name: String, val age: Int) {
	override def toString = getClass.getName + " =>[name=" + name +
			",age=" + age + "] =>"
}

class Employee19(name: String, age: Int, val salary : Double) extends
Person19(name, age) {
	override def toString = super.toString + " [salary=" + salary + "]"
}


object Main19 extends App {
	println(new Employee19("Fred", 42, 50000))
}