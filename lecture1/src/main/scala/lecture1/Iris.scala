package lecture1

import scala.io.Source
import java.io.PrintWriter

/**
 * Created by wildfire on 29/04/14.
 */
object Iris {

  //All lines of source file
  val allLines = Source.fromFile("data/iris.data").getLines().toSeq

  //No blank lines
  val sampleLines: Seq[String] = ???

  object IrisClass extends Enumeration {
    val Setosa, Versicolor, Virginica = Value

    def unapply(s: String): Option[Value] = s match {
      case "Iris-setosa" => Some(Setosa)
      case "Iris-versicolor" => Some(Versicolor)
      case "Iris-virginica" => Some(Virginica)
      case _ => None
    }

    def of(s: String): Value = s match {
      case IrisClass(v) => v
      case _ => throw new IllegalArgumentException
    }

    def toString(v: Value): String = v match {
      case Setosa => "Iris-setosa"
      case Versicolor => "Iris-versicolor"
      case Virginica => "Iris-virginica"
    }
  }

  case class Sample(
    sepalLength: Double,
    sepalWidth: Double,
    petalLength: Double,
    petalWidth: Double,
    cls: IrisClass.Value
  )

  def parseSample(s: String): Sample = {
    val parts = s.split(",")
    new Sample(parts(0).toDouble, parts(1).toDouble, parts(2).toDouble, parts(3).toDouble, IrisClass.of(parts(4)))
  }

  //All valid samples
  lazy val samples: Seq[Sample] = ???

  //Samples with sepalLength <= 6.0
  lazy val shortSepalSamples: Seq[Sample] = ???

  //shortSepalSamples grouped by class
  lazy val shortByClass: Map[IrisClass.Value, Seq[Sample]] = ???

  //Count of shortSepalSamples by class
  lazy val shortSpeciesCounts: Map[IrisClass.Value, Int] = ???

  //Max item of sequence
  def max(s: Seq[Double]): Double = ???

  //Max petal length of shortSepalSamples by class
  lazy val maxSpeciesPetalLength: Map[IrisClass.Value, Double] = ???

  //Sequence mean
  def mean(s: Seq[Double]): Double = ???

  //Mean petal length of shortSepalSamples by class
  lazy val meanSpeciesPetalLength: Map[IrisClass.Value, Double] = ???

  //Variance without Bessel's correction
  def uncorrectedVariance(s: Seq[Double]): Double = ???

  //Variance with Bessel's correction
  def correctedVariance(s: Seq[Double]): Double = ???

  def sd(s: Seq[Double]) = Math.sqrt(correctedVariance(s))

  //Mean petal length of shortSepalSamples by class
  lazy val sdSpeciesPetalLength: Map[IrisClass.Value, Double] = ???

  def writeSamples(w: PrintWriter, samples: Seq[Sample]) = {
    samples.map(s => s"${s.sepalLength},${s.sepalWidth},${s.petalLength},${s.petalWidth},${IrisClass.toString(s.cls)}\n").foreach(s => w.write(s))
  }

}
