package RDDs

import org.apache.spark.{SparkConf, SparkContext}

/*

Given the data in below format

customerId, itemId, price

Calculate the total price spent by each customer.

 */
object TotalPurchaseByCustomer {

  def main(args: Array[String]): Unit = {


    val sc = {

      val conf = new SparkConf().setAppName("customerPurchase").setMaster("local[*]")

      new SparkContext(conf)

    }

    val customerDataRdd = sc.textFile("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/customer-orders.csv")

    val customerToPriceRdd = customerDataRdd.map(line => (line.split(",")(0), line.split(",")(2).toFloat))

    val resultRdd = customerToPriceRdd.reduceByKey((x, y) => x + y)

    val sortedByAmtSpent = resultRdd.map(x => (x._2, x._1)).sortByKey(false)

    sortedByAmtSpent.collect().foreach(println)
  }
}
