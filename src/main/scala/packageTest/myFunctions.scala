package packageTest

import packageTest.myPackageProgram.rec

import scala.util.{Failure, Success, Try}

class myFunctions {
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int =
      if (x > b) acc
      else loop(x + 1, acc + f(x))

    loop(a, 0)
  }

  val cond: (Int, Int) => Boolean = (x, y) => x <= y

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => x :: Nil
      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }

  def sqrt(x: Double): Try[Double] =
    if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
    else Success(x)

  val f: (Int => Int) = (x: Int) => x * x

}
