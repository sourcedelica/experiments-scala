package experiments

import com.twitter.concurrent.{Broker, Offer}
import com.twitter.util.{ScheduledThreadPoolTimer, Future}
import collection.immutable.Queue
import com.twitter.conversions.time._
import annotation.tailrec

case class Conn()

object OfferBroker {
  val conns = List(Conn())

  val pool = new Pool(conns)

  implicit val timer = new ScheduledThreadPoolTimer(2, "timer", false)

  val conn: Future[Option[Conn]] = Offer.choose(
    pool.get { conn => Some(conn) },
    Offer.timeout(1.second)(timer) { _ => None }
  ).sync()
}

@tailrec
class Pool(conns: Seq[Conn]) {
  private[this] val waiters = new Broker[Conn]
  private[this] val returnConn = new Broker[Conn]

  val get: Offer[Conn] = waiters.recv
  def put(c: Conn) { returnConn ! c }

  private[this] def loop(connq: Queue[Conn]) {
    Offer.choose(
      if (connq.isEmpty) Offer.never else {
        val (head, rest) = connq.dequeue
        waiters.send(head) { _ => loop(rest) }
      },
      returnConn.recv { c => loop(connq enqueue c) }
    ).sync()
  }

  loop(Queue.empty ++ conns)
}

