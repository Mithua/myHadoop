package ds.stat4

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

/** Count up how many of each word appears in a book as simply as possible. */
object LogAnalyzer {

	/** Our main function where the action happens */
	def main(args: Array[String]) {

		// Set the log level to only print errors
		Logger.getLogger("org").setLevel(Level.ERROR)

		// Create a SparkContext using every core of the local machine
		val sc = new SparkContext("local[*]", "LogAnalyzer")   

		// Read each line of my book into an RDD
		val input = sc.textFile("../server_log")

		val errors = input.filter(_.startsWith("ERROR"))

		val messages = errors.map(_.split("\t")).map(r => r(1))

		messages.cache

		val tot = input.count

		val msql = messages.filter(_.contains("mysql")).count

		val php = messages.filter(_.contains("php")).count

		val rail = messages.filter(_.contains("RailsApp")).count
		/*
			Now this logic right now is printing the statistics on console,
			you could save the results in a file, or DB or even pass message
			to other system here
		 */
		println("Total msgs: %s, MySQL errs: %s, PHP errs: %s, Rails: %s, DONE: %s".format(tot, msql, php, rail, (tot - (msql+php+rail))))
	}
}

