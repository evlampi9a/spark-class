package lecture1

import org.scalatest.{Matchers, FlatSpec}
import lecture1.Iris.{IrisClass, Sample}
import java.io.{File, PrintWriter}

/**
 * Created by wildfire on 29/04/14.
 */
class IrisSpec extends FlatSpec with Matchers {

  "An Iris object " should "read correct file " in {
    assertResult(151) {
      Iris.allLines.size
    }
  }

  it should "strip empty lines" in {
    assertResult(150) {
      Iris.sampleLines.size
    }
  }

  it should "parse sample correctly" in {
    assertResult(new Sample(5.1, 3.5, 1.4, 0.2, IrisClass.Setosa)) {
      Iris.parseSample(Iris.sampleLines(0))
    }
  }

  it should "evaluate samples correctly" in {
    assertResult(new Sample(5.1, 3.5, 1.4, 0.2, IrisClass.Setosa)) {
      Iris.samples(0)
    }
    assertResult(new Sample(6.9, 3.1, 5.4, 2.1, IrisClass.Virginica)) {
      Iris.samples(139)
    }
  }

  it should "filter short samples" in {
    assertResult(89) {
      Iris.shortSepalSamples.length
    }
  }

  it should "count filtered samples" in {
    assertResult(Map(IrisClass.Setosa -> 50, IrisClass.Versicolor -> 30, IrisClass.Virginica -> 9)) {
      Iris.shortSpeciesCounts
    }
  }

  it should "calculate max petal length by class correctly" in {
    assertResult(Map(IrisClass.Setosa -> 1.9, IrisClass.Versicolor -> 5.1, IrisClass.Virginica -> 5.1)) {
      Iris.maxSpeciesPetalLength
    }
  }

  val beWithinTolerance = be >= -0.01 and be <= 0.01

  it should "calculate mean petal length by class correctly" in {
    (Iris.meanSpeciesPetalLength(IrisClass.Setosa) - 1.46) should beWithinTolerance
    (Iris.meanSpeciesPetalLength(IrisClass.Versicolor) - 4.04) should beWithinTolerance
    (Iris.meanSpeciesPetalLength(IrisClass.Virginica) - 4.96) should beWithinTolerance
  }

  it should "calculate sd petal length by class correctly" in {
    (Iris.sdSpeciesPetalLength(IrisClass.Setosa) - 0.17) should beWithinTolerance
    (Iris.sdSpeciesPetalLength(IrisClass.Versicolor) - 0.46) should beWithinTolerance
    (Iris.sdSpeciesPetalLength(IrisClass.Virginica) - 0.20) should beWithinTolerance
  }

  it should "write samples to file" in {
    val writer = new PrintWriter(new File("target/iris_short.data"))
    try {
      Iris.writeSamples(writer, Iris.shortSepalSamples)
    } finally {
      writer.close
    }

  }
}
