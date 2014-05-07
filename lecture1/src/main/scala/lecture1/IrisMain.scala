package lecture1

/**
 * Created by wildfire on 07/05/14.
 */
object IrisMain {

  def main(args: Array[String]) = {
    //Sample #1
    println(IrisClassifier(Array(5.1, 3.5, 1.4, 0.2)))
    //Sample #51
    println(IrisClassifier(Array(7.0, 3.2, 4.7, 1.4)))
    //Sample #101
    println(IrisClassifier(Array(6.3, 3.3, 6.0, 2.5)))
  }
}
