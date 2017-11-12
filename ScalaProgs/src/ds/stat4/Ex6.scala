package ds.stat4

class AuxDuck{
	var size = 0;
	var age = 0;
	println("Sathya")

	def this(size: Int){
		this() // Calls the primary constructor
		this.size= size
	}

	def this(size:Int, age:Int)
	{
		this(size) // calls previous auxiliary constructor
		this.age= age
	}
}

object DemoDuck extends App {
	var d1 = new AuxDuck
			var d2 = new AuxDuck(5)
			var d3 = new AuxDuck(5,10)
			println (d1.size + "," + d1.age)
			println (d2.size, d2.age)
			println (d3.size, d3.age)
}