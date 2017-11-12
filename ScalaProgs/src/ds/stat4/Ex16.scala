package ds.stat4

class Person16 {
	var name = ""
}

class Employee extends Person16 {
	var salary = 0.0
			def description = "Employee Name is:- " + name + " and salary is:- " + salary
}

object Main16 extends App {
	val fred = new Employee
			fred.name = "Vishal Kumar"
			fred.salary = 500000
			println(fred.description)
}