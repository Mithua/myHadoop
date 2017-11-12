package ds.stat4

object SingletonReservations{
	private var lastNum= 0;
	def newReservationNum() = { lastNum+=1; lastNum}
}

object DemoRes extends App {
	val r1 = SingletonReservations.newReservationNum
			val r2 = SingletonReservations.newReservationNum
			val r3 = SingletonReservations.newReservationNum
			println("r1: " + r1 + " r2: "+ r2 + " r3: " + r3)
}