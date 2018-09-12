package experiments

case class Foo()

class SerializableParameterClient {
  val o1 = new SerializableParameter(1, Foo(), "ss")
  val o2 = new SerializableParameter(2, List.empty[Foo], "ss")

  o1.meth(1, Foo(), "ss")
}
