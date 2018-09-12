package experiments

object SO19611479 {
  class MyClass[A, Int] extends collection.immutable.Map[A, Int] {
    private val map = collection.immutable.Map.empty[A, Int]

    def get(key: A): Option[Int] = {
      map.get(key)
    }

    def iterator: Iterator[(A, Int)] = {
      map.iterator
    }

    def -(key: A): Map[A, Int] = {
      map - key
    }

    def +[B1 >: Int](kv: (A, B1)): Map[A, B1] = {
      map + kv
    }
  }
}
