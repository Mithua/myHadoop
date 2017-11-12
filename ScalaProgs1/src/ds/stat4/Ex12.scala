package ds.stat4

/*
 * This example is just a demo of various useful
 * higher order functions available with collections 
 */
object Main12 extends App {
	def demo{
		//(1 to 9).map(0.1 * _).foreach(println)
		//(1 to 9).map("*" * _).foreach(println _)
		//(1 to 9).filter(_ % 2 == 0).foreach(println _)
		//println((1 to 4).reduceLeft(_ * _))

		val x = "Mary had a little lamb".split(" ").sortWith(_.length < _.length)
				for (i <- x) println(i)
	}
	demo
}