package ds.stat4

class Duck{
	var size = 1
}

object DuckDemo extends App {
	var f = new Duck
			f.size = 10 // It calls f.size_=(10)
			// f.size_=(10) // It calls f.size_=(10)
			println(f.size) // It calls f.size()
}
