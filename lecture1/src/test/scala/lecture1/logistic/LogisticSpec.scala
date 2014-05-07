package lecture1.logistic

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by wildfire on 07/05/14.
 */
class Poly2(a: Double, b: Double, c: Double) extends Differentiable {

  override def apply(args: Array[Double]): Double = {
    if (args.length != 1) throw new IllegalArgumentException
    val x = args(0)
    a * x * x + b * x + c
  }

  override def gradient(args: Array[Double]): Array[Double] = {
    if (args.length != 1) throw new IllegalArgumentException
    val x = args(0)
    Array(2 * a * x + b)
  }
}


class LogisticSpec extends FlatSpec with Matchers {

  val beWithinTolerance = be >= -0.01 and be <= 0.01

  "A GradientDescent" should "work for x^2 function" in {
    val poly2 = new Poly2(1, 0, 0)
    val gd = new GradientDescent(0.01, 50) //XXX: Depending on GD implementation this probably should be adjusted
    val min = gd(poly2, Array(10.0))
    assertResult(1) {min.length}
    (min(0) - 0.0) should beWithinTolerance
  }

  //TODO: Other tests
}
