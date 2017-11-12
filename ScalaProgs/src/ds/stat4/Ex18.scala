package ds.stat4

class Person18 {
	var name = ""
			override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee18 extends Person18 {
	var salary = 0.0
			override def toString = super.toString + "[salary=" + salary + "]"
}

class Manager extends Employee18

object Main extends App {
	val r = scala.math.random
			println("value of r is--> " + r)
			val p = if (r < 0.33) new Person18 
			else if (r < 0.67) new Employee18 
			else new Manager  
			if (p.isInstanceOf[Employee18]) {     
				val s = p.asInstanceOf[Employee18] // s has type Employee
						println("It's an employee.")
						s.salary = 50000

						if (p.getClass == classOf[Manager]) {
							println("Actually, it's a manager")
							s.salary *= 2
						}
			}
	if (p.getClass == classOf[Person18]) {
		println("This is Just a person!")
	}
	println(p)
}
