package lecture1

import lecture1.logistic.{CostFunction, LogisticClassifier, LogisticCostFunction, Differentiable}
import Iris.{Sample, IrisClass}

/**
 * Created by wildfire on 07/05/14.
 */
class IrisCostFunction(val cls: Iris.IrisClass.Value) {

  def apply(sample: Iris.Sample): Differentiable =
    new LogisticCostFunction(Array(sample.sepalLength, sample.sepalWidth, sample.petalLength, sample.petalWidth), sample.cls == cls)
}

object IrisClassifier {

  private def oneVsMany(cls: IrisClass.Value): LogisticClassifier =
    LogisticClassifier.train(new CostFunction[Sample](Iris.samples, new IrisCostFunction(cls).apply))

  private lazy val classifiers: Map[IrisClass.Value, LogisticClassifier] = IrisClass.values.toSeq.map(cls => cls -> oneVsMany(cls)).toMap

  def apply(x: Array[Double]): IrisClass.Value = classifiers.mapValues(_.hypothesis(x)).maxBy(_._2)._1

}
