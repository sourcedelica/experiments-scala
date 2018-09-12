package experiments

import akka.actor.{Props, ActorSystem, Actor}

class ReceiveWrapper extends Actor {

  def w(r: => Receive): Receive = new Receive {
      def isDefinedAt(x: Any): Boolean = {
        r.isDefinedAt(x)
      }
      def apply(x: Any): Unit =
        try {
          r.apply(x)
        } catch {
          case ex: Exception => println("caught it!")
        }
    }

  def id(r: Receive): Receive = r

  def receive = w(cases)

  def cases: Receive = {
    case "hey" => println("ho")
    case "bang" => throw new Exception("why?")
    case _ => println("wha?")
  }

//  def receive = w(r)
}

object ReceiveWrapper extends App {
  val system = ActorSystem()

  val rw = system.actorOf(Props(new ReceiveWrapper))

  rw ! "hey"
  rw ! "bang"

  system.shutdown()
}
