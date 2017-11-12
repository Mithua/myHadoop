package ds.stat4

object Main10 extends App {
	def sumInts(a: Int, b: Int): Int =
			if(a > b) 0 else a + sumInts(a + 1, b)

			def cube(x: Int): Int= x * x * x

			def sumCubes(a: Int, b: Int): Int=
			if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

			//println(sumInts(3,5))

			println(sumCubes(3, 5))

}