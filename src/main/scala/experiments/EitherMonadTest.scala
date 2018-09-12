package experiments

import scalaz._
import Scalaz._

object EitherMonadTest extends App {
  val e1: Either[Nothing, String] = Right("foo")
  val f1 = (s: String) => Right(s.length)
  val f2 = (i: Int) => Right("length=" + i)

  val et = e1 >>= f1 >>= f2

  println(et)
}
