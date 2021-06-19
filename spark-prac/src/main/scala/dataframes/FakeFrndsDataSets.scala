package dataframes

import org.apache.spark.sql.SparkSession

/*
We need to create sparkSession to work with dataframes and datasets.
 */
object FakeFrndsDataSets {


  // Parameters to the case class must match actual column names of the dataset.

  case class Person( id: Int, name: String, age: Int, friends: Int)

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder
      .appName("SparkSQL")
      .master("local[*]")
      .getOrCreate();

    import spark.implicits._

    val schemaPeople =spark.read
                      .option("header","true")
                      .option("inferSchema","true")
                      .csv("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/fakefriends.csv")
        .as[Person]

    schemaPeople.printSchema()


    schemaPeople.createOrReplaceTempView("people")

    val teenager = spark.sql("select * from people where age >= 13 and age <=19")

    val results = teenager.collect()

    results.foreach(println)

    // Dataframe API
    schemaPeople.filter(schemaPeople("age") < 21).show()

    schemaPeople.select(schemaPeople("name"),schemaPeople("age")+10).show(

    )

    spark.stop()


  }

}
