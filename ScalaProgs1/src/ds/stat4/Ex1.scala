package ds.stat4

//import java.io.Serializable

trait Logger1 {
	def log(msg: String) // An abstract method
}

class ConsoleLogger1 extends Logger1 {
	def log(msg: String) { println(msg) } // No override needed
}

object Main1 extends App {
	val logger = new ConsoleLogger1
			logger.log("Hi..! I am printing from Main..!!")
}