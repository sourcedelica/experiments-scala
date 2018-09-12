package experiments

object FibMemo1 extends App {
  type Memo = Map[BigInt, BigInt]

  def fibmemo1(n: BigInt): BigInt = {
    def fibmemoR(z: BigInt, memo: Memo): (BigInt, Memo) =
      if(z <= 1)
        (z, memo)
      else memo get z match {
        case None =>
          val (r, memo0) = fibmemoR(z - 1, memo)
          val (s, memo1) = fibmemoR(z - 2, memo0)
          (r + s, memo1)

        case Some(v) => (v, memo)
      }

    fibmemoR(n, Map())._1
  }

  fibmemo1(10)
}
