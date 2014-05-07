package lecture1

/**
 * Created by wildfire on 07/05/14.
 */
package object logistic {

  /**
   * The representation of any function differentiable once
   *
   */
  trait Differentiable {

    def apply(args: Array[Double]): Double

    def gradient(args: Array[Double]): Array[Double]
  }

  /**
   * The representation of any cost function for the dataset.
   *
   * The value of cost function is defined as the sum of individual costs of all samples.
   * The gradient of cost function is defined as the sum of gradients over dataset
   *
   * @param data        array of all samples
   * @param sampleCost  the function that produces differentiable function for a sample of dataset
   * @tparam S          type of samples
   */
  class CostFunction[S](val data: Seq[S], sampleCost: S => Differentiable) extends Differentiable {

    override def apply(theta: Array[Double]): Double = ???

    override def gradient(theta: Array[Double]): Array[Double] = ???
  }

  /**
   * Allows to performs gradient descent on a differentiable function.
   *
   * The params of descent are specified upon construction whereas the function and starting point are specified
   * upon application.
   *
   * @param alpha       step of gradient descent
   * @param iterations  number of iterations
   */
  class GradientDescent(val alpha: Double, val iterations: Int) {

    def apply(f: Differentiable, theta0: Array[Double]): Array[Double] = ???
  }

  /**
   * Computes sigmoid function
   *
   */
  def sigmoid(z: Double): Double = ???

  /**
   * Cost function of a sample for the logistic regression.
   *
   * Note that theta.size = x.size + 1
   *
   * @param x   sample features
   * @param y   sample class (false - negative, true - positive)
   */
  class LogisticCostFunction(val x: Array[Double], val y: Boolean) extends Differentiable {

    override def apply(theta: Array[Double]): Double = ???

    override def gradient(theta: Array[Double]): Array[Double] = ???
  }

  /**
   * Allows to classify samples with logistic regression
   *
   * Note that theta.size = x.size + 1
   *
   * @param theta
   */
  class LogisticClassifier(val theta: Array[Double]) {

    /**
     * Uses hypothesis to classify the sample.
     *
     * @param x   the sample to classify
     * @return
     */
    def apply(x: Array[Double]): Boolean = ???

    /**
     * Returns value of hypothesis for the logistic regression.
     *
     * @param x
     * @return
     */
    def hypothesis(x: Array[Double]): Double = ??? //Or replace it with some value to make demo running 0.8
  }

  object LogisticClassifier {

    def train[S](costFunction: CostFunction[S]): LogisticClassifier = ??? //Or replace it with new LogisticClassifier(Array(0.0))
  }
}
