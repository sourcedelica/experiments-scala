package experiments

class SerializableParameter {
  def this(i: Int, s: Serializable, ss: String) {
    this()
  }

  def this(i: Int, s: List[Serializable], ss: String) {
    this()
  }

  def meth(i: Int, s: Serializable, ss: String) {}
}
