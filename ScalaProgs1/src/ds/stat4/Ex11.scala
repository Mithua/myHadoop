package ds.stat4

object Main11 extends App{
	def sum(f: Int=> Int, a: Int, b: Int): Int=
			if(a > b) 0
			else f(a) + sum(f, a + 1, b)

			def id(x: Int): Int= x
			def cube(x: Int): Int= x * x * x
			def fact(x: Int): Int= if (x == 0) 1 else fact(x -1)

			def sumInts(a: Int, b: Int) = sum(id, a, b)
			def sumCubes(a: Int, b: Int) = sum(cube, a, b)
			def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

			println(sumInts(1, 2))
			//println(sumCubes(1,2))
			//println(sumFactorials(1,2))

			/*
			 * The sane example could be re-written as shown below:
			 */
			//def sumInts(a: Int, b: Int) = sum(x=> x, a, b)
			//def sumCubes(a: Int, b: Int) = sum(x => x*x*x, a, b) 
			//def sumFactorials(a: Int, b: Int) = sum(x => if (x == 0) 1 else fact(x - 1), a, b)

			/*
			 * The same example could be re-written as shown below:
			 */

			// def sumInts(a: Int, b: Int) = sum(1*_, a, b)
			//println(sumInts(1,2))
			//println(sumCubes(1,2))


}