package RDDs

import org.apache.spark.{SparkConf, SparkContext}

/*

Given a dataset with age and num of frnds, find the average number of friends per age

age numFriends

35,  38
34,  48
52,  446
34,  110
49   120
52   2
27   154
52   10

Avg frnds for age 52 = (446+2+10)/3

 */
object AverageFriendsByAge {


  def main(args: Array[String]): Unit = {


    val sc = {

      val sparkConf = new SparkConf().setAppName("AverageFriends").setMaster("local[*]")

      new SparkContext(sparkConf);
    }

    val friendsRdd = sc.textFile("/home/divya02/demo-projects/prac/spark-prac/src/main/resources/fakefriends-noheader.csv")

    val ageToNumFriendsRdd = friendsRdd.map(line => (line.split(",")(2), line.split(",")(3)));


    val ageToNumFrndsKVRdd = ageToNumFriendsRdd.mapValues(value => (value.toInt, 1))


    val ageToNumFrndsReducedKVRdd = ageToNumFrndsKVRdd.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))

//    ageToNumFrndsReducedKVRdd.collect().foreach(println)

    val avgAgeRdd = ageToNumFrndsReducedKVRdd.mapValues(value => (value._1 / value._2))


    avgAgeRdd.collect().sorted.foreach(println)
  }

}
