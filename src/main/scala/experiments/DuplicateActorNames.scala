package experiments

import akka.actor._
import akka.actor.Actor.emptyBehavior
import akka.pattern.gracefulStop
import concurrent.duration._

object DuplicateActorNames extends App {
  implicit val system = ActorSystem()
  implicit val timeout = 15.seconds

  val actor1 = system.actorOf(Props(new Actor {
    var child: ActorRef = _

    override def preStart() {
      child = context.actorOf(Props(new Actor {
        def receive = emptyBehavior
      }))
      context watch child
    }

    def receive = {
      case Terminated(actor) =>
        println("child in children? " + context.children.exists(_ == child))
        context stop self
      case "stop" =>
        println("stopping " + child)
        context stop child
    }

    override def unhandled(message: Any) {
      println("unhandled: " + message)
    }
  }), "test")

  actor1 ! "stop"



  val actor2 = system.actorOf(Props(new Actor {
    def receive = emptyBehavior
  }), "test")

  system.shutdown()
}
