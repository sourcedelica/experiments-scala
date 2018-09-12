package experiments

import akka.actor.{Props, ActorSystem, Actor}

case class GetUser()

trait FromSupport { this: Actor =>
  case object from {
    def unapply(msg: Any) = Some(msg, sender)
  }
}

class MyActor extends Actor with FromSupport {
  def receive = {
    case (request: GetUser) from sender =>
      println("request=" + request + " sender=" + sender)
//    case from(request, sender) =>
//      println("request=" + request + " sender=" + sender)
  }
}

object FromSupportTest extends App {
  val system = ActorSystem()

  val ma = system.actorOf(Props(new MyActor))

  val ta = system.actorOf(Props(new Actor {
    override def preStart() { ma ! GetUser() }
    def receive = { case _ => }
  }))

  system.shutdown()
}


