package empty

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by wildfire on 12/05/14.
 */
object Main {

  def main(args: Array[String]) = {
    val conf = new SparkConf().setMaster("local").setAppName("Sequence summ")
    val sc: SparkContext = new SparkContext(conf)
    val rdd = sc.parallelize(Range(0, 10000))
    val result = rdd.map(_.toLong).reduce(_ + _)
    println(s"Result: $result")
  }
}
