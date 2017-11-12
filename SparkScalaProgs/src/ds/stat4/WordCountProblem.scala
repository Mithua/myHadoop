package ds.stat4

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCountProblem {
	def main(args: Array[String]) {
	  val sc = new SparkContext("local", "Word Count Problem")
		val logFile = "../book.txt";
		val input = sc.textFile(logFile)
		val words = input.flatMap(line => line.split(" "))
		val units = words.map( word => (word, 1) )
		val counts = units.reduceByKey ( (x, y) => x + y )
		counts.foreach(println)	
		println(" ++++++++++++++++ Total Word Count +++++++++++++++++++++ " );
	}
}
