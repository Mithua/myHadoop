
// keep the access_log.txt in the folder nc111nt that contains nc.exe file
// double click nc.exe file to open the netcat console window
// run Eclipse -> you will notice that the counts = 0
// type 'nc -l -p 9999 < access_log.txt' -> this will generate streaming data from the log file
// after 30 odd seconds, paste again access_log2.txt (a copy) in the same folder
// type again 'nc -l -p 9999 < access_log2.txt' -> this will add more (double) streaming data from the copy of the log file

package ds.stat4

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.storage.StorageLevel

import java.util.regex.Pattern
import java.util.regex.Matcher

import Utilities._

/** Maintains top URL's visited over a 5 minute window, from a stream
 *  of Apache access logs on port 9999.
 */
object LogParser {
 
  def main(args: Array[String]) {

    // Create the context with a 1 second batch size
    val ssc = new StreamingContext("local[*]", "LogParser", Seconds(1))
    
    setupLogging()
    
    // Construct a regular expression (regex) to extract fields from raw Apache log lines
    val pattern = apacheLogPattern()

    // Create a socket stream to read log data published via netcat on port 9999 locally
    val lines = ssc.socketTextStream("127.0.0.1", 9999, StorageLevel.MEMORY_AND_DISK_SER)
    
    // Extract the request field from each log line
    val requests = lines.map(x => {val matcher:Matcher = pattern.matcher(x); if (matcher.matches()) matcher.group(5)})
    
    // Extract the URL from the request
    val urls = requests.map(x => {val arr = x.toString().split(" "); if (arr.size == 3) arr(1) else "[error]"})
    
    // Reduce by URL over a 1-minute window sliding every second
    val urlCounts = urls.map(x => (x, 1)).reduceByKeyAndWindow(_ + _, _ - _, Seconds(60), Seconds(1))
    
    // Sort and print the results
    val sortedResults = urlCounts.transform(rdd => rdd.sortBy(x => x._2, false))
    sortedResults.print()
    
    // Kick it off
    ssc.checkpoint("C:/checkpoint/")
    ssc.start()
    ssc.awaitTermination()
  }
}
