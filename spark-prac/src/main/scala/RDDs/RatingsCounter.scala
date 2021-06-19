package RDDs

import org.apache.spark.{SparkConf, SparkContext}

object RatingsCounter {


  def main(args: Array[String]): Unit = {

    val sc = {

      val sparkCnf = new SparkConf().setMaster("local[*]").setAppName("ratingsCounter")

      new SparkContext(sparkCnf);
    }

    val moviesRdd = sc.textFile("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/u.data")

    val ratingsRdd = moviesRdd.map(x => x.split("\t")(2));

    // Order in descending order of value.
    val result = ratingsRdd.countByValue().toSeq.sortBy(_._1)(Ordering[String].reverse)

    println(result)
  }

}
