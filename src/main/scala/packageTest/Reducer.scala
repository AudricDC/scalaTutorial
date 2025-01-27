package packageTest

abstract class Reducer(init: Int) {
  def combine(x: Int, y: Int): Int
  def reduce(xs: List[Int]): Int =
    xs match {
      case Nil => init
      case y :: ys => combine(y, reduce(ys))
    }
}

object Product extends Reducer(1) {
  def combine(x: Int, y: Int): Int = x * y
}

object Sum extends Reducer(0) {
  def combine(x: Int, y: Int): Int = x + y
}