package experiments

import collection.generic.CanBuildFrom

object StructuralMap extends App {
  type HasMapAndForeach[A] = {
//    def map[B, That](f: (A) ⇒ B)(implicit bf: CanBuildFrom[List[A], B, That]): That
    def foreach[B](f: (A) ⇒ B): Unit
  }

  def printValues(xs: HasMapAndForeach[Any]) {
    xs.foreach(println _)
  }

//  def mapValues(xs: HasMapAndForeach[Any]) {
//    xs.map(_.toString).foreach(println _)
//  }

  def forComp1(xs: HasMapAndForeach[Any]) {
    for (i <- xs) println(i)
  }

  printValues(List(1,2,3))

  printValues(Some(4))

  printValues(Seq(5,6,7))

  forComp1(List(8,9,10))

//  mapValues(Seq(1,2,3))
}