package dataframes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object WordCountUsingDataSets {

  case class Book(value: String)
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("wordCount").master("local[*]").getOrCreate()

    import spark.implicits._

    val input = spark.read.text("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/book.txt").as
      [Book]


    val words = input.select(explode(split($"value","\\W+"))).alias("word").filter($"col" =!= "")


   val lowerCaseWords = words.select(lower($"col").alias("word"))

    lowerCaseWords.show()

    val wordCount = lowerCaseWords.groupBy("word").count()

    wordCount.sort("count").show(wordCount.collect().length)


    // Blending RDDs and Datasets.

    val sparkContext = spark.sparkContext;

    val wordsRdd = sparkContext.textFile("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/book.txt")

    val wordsRDD = wordsRdd.flatMap(x => x.split("\\W+"))

    val wordsDS = wordsRDD.toDS()

    val lowerWordDS = wordsDS.select(lower($"value").alias("word"))

    val wordCounts = lowerWordDS.groupBy($"word").count().sort($"count")

    wordCounts.show(wordCounts.collect().length)
  }

}
