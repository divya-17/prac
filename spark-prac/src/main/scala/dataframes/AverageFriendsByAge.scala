package dataframes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

case class Friends(id: Int,name: String,age: Int,friends:Int)

object AverageFriendsByAge {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("AverageFrndsByAge").master("local[*]").getOrCreate()


    import spark.implicits._
    val fakeFrndsDS = spark.read
      .option("inferSchema","true")
      .option("header","true")
      .csv("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/fakefriends.csv").as[Friends]



    fakeFrndsDS.createOrReplaceTempView("fakeFrnds")

    val result = spark.sql("select age,avg(friends) from fakeFrnds group by age")

    result.collect().foreach(println)

    val dataFrameResult = fakeFrndsDS.groupBy("age").agg(round(avg("friends"),2).alias("friends_avg")).sort("age").show()


    spark.stop()
  }

}
