import akka.actor.{Stash, Actor}

class StashTest extends Actor with Stash {
  def receive = {
    case "open" ⇒
      unstashAll()
      context.become({
        case "write" ⇒ // do writing...
        case "close" ⇒
          unstashAll()
          context.unbecome()
        case msg ⇒ stash()
      }, discardOld = false)
    case "done" ⇒ // done
    case msg    ⇒ stash()
  }
}