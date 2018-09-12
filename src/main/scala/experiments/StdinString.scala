package experiments

    import java.io.ByteArrayInputStream
    import scala.sys.process._

    object StdinString extends App {
      val cmd = List("cat")
      val inputString = "hello\nworld"
      val is = new ByteArrayInputStream(inputString.getBytes("UTF-8"))

      val out = (cmd #< is).lines_!
      out.foreach(println)
    }
