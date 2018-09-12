package experiments

import scalaz._, Scalaz._

object EachOrFunctor extends App {
  def incremented[F[_]: Functor](xs: F[Int]) = xs map (_ + 1)

  def incremented2[F[_]](xs: F[Int])(implicit ev: Functor[F]) = {
    val xsMa = maImplicit(xs)

    xsMa
  }

  def printValues[F[_]: Each](xs: F[Int]) = xs foreach println

  val r1 = incremented2(List(1,2,3))
  r1.foreach(println _)

  printValues(Some(1))
}
