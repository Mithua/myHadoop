package ds.stat4

class Person17 {
	var name = ""
			override def toString = getClass.getName + "=> [name=" + name + "]"
}

class Employee17 extends Person17 {
	var salary = 0.0
			override def toString = super.toString + "=> [salary=" + salary + "]"
}

object Main17 extends App {
	val vishal = new Employee17
			vishal.name = "Vishal "
			vishal.salary = 500000
			println(vishal)
}