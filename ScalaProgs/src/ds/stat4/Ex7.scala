package ds.stat4

class PrimDuck(val size:Int, val age:Int) {
	println("Inside duck constructor")
	def desc= "Duck of age "+ age + " is of size "+ size
}


object DemoPrimDuck extends App {
	var d1 = new PrimDuck(10, 5)
	println(d1.desc)
}