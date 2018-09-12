package experiments

import java.util.UUID

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

// https://viktorklang.com/blog/Futures-in-Scala-protips-1.html

object Customers {
  final case class Customer(uuid: UUID)

  abstract class CustomerComponent {
    type EC[_] = ExecutionContext
    final def byId[_ : EC](customerId: UUID): Future[Customer] =
      selectCustomer(customerId)
    protected def selectCustomer[_ : EC](uuid: UUID): Future[Customer]
  }
}

object EcContextBound extends App {
  class CustomerImpl extends Customers.CustomerComponent {
    override def selectCustomer[_: EC](uuid: UUID): Future[Customers.Customer] = {
      println(implicitly[EC[_]])
      Future.successful(Customers.Customer(uuid))
    }
  }

  class Runner {
    implicit val ec: ExecutionContext = ExecutionContext.Implicits.global
    val c = new CustomerImpl

    def run(): Unit = {
      println(Await.result(c.selectCustomer(new UUID(1L, 2L)), Duration.Inf))
    }
  }

  val runner = new Runner
  runner.run()
}
