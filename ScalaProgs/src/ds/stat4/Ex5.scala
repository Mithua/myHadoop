package ds.stat4

class PrivateCounter {
	private var value = 0
			def incr() { value +=1 }
	def current= value
			def isLess(otherVal: PrivateCounter) = value < otherVal.value
}

class ObjectOnlyCounter {
	private[this] var value = 0
			def incr() { value +=1 }
	def current= value
			//def isLess(otherVal: ObjectOnlyCounter) = value < otherVal.value
}


object PrivateCtr extends App {
	var f1 = new PrivateCounter
			var f2 = new PrivateCounter
			f1.incr
			f1.incr
			f2.incr
			println(f2.isLess(f1)) // It calls f.size()
}