package ds.stat4

class CompAccount{
	val id = CompAccount.newNum()
			private var bal = 0.0
}

object CompAccount{
	private var lastNum= 0;
	private def newNum() = { lastNum+=1; lastNum}
}

object DemoComp extends App {
	val r1 = new CompAccount
			println("id1: " + r1.id)
			println("id2: " + r1.id)
}