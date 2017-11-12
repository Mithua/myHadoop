package ds.stat4

class ReadOnlyCounter
{
	private var value = 0
			def incr() { value +=1 }
	def current= value
}

object ReadOnlyCtr extends App {
	var f = new ReadOnlyCounter
			f.incr
			println(f.current) // It calls f.size()
}
