package RDDs

import org.apache.spark.{SparkConf, SparkContext}
import scala.math.min

/*

Given station to temperature dataset find minimum temp reported by a station.

 */
object MinTemperature {

  def parseLine(line: String):(String,String,Float) = {

    val fields = line.split(",")
    val stationId = fields(0)
    val entryType = fields(2)
    val temperature = fields(3).toFloat * 0.1f * (9.0f/5.0f) + 32f

    (stationId,entryType,temperature)

  }
  def main(args: Array[String]): Unit = {

    val sc = {

      val sparkConf = new SparkConf().setAppName("MinimumTemperature").setMaster("local[*]")

      new SparkContext(sparkConf);
    }

    val lines = sc.textFile("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/1800.csv")

    val parsedLines = lines.map(parseLine)

    val tMinTempRdd =parsedLines.filter(x => x._2=="TMIN").map(x =>(x._1,x._3))

    val result = tMinTempRdd.reduceByKey((x,y) => min(x,y))

    result.collect().foreach(println)
  }
}
