import scala.language.higherKinds

case class Payment(amount: Option[Int], beneficiaryName: String, payerName: String)

trait PaymentValidationAlg[F[_]] {
  def validate(payment: Payment): F[Payment]
}

trait PaymentSubmissionAlg[F[_]] {
  def submit(payment: Payment): F[Payment]
}

import cats.Monad
import cats.implicits._

class PaymentValidationInterpreter[F[_]: Monad] extends PaymentValidationAlg[F]{

  def validate(payment: Payment): F[Payment] = {
    val p = for {
      v <- validateName[F](payment)
      //      a <- validateAmount(payment)
    } yield v

    p
  }


  private def validateName[F[+_]: Monad](payment: Payment): F[Payment] = {
    val validName = """[a-zA-z\ ]{1,15}""".r
    val valid = List(payment.beneficiaryName, payment.payerName).foldRight(true)((e, a) => (a && (e match {
      case validName(_*) => true
      case _ => false
    })))


    Monad[F].pure(payment)
  }


  //  private def validateAmount(payment: Payment): F[Payment] = {
  //    val valid = payment.amount match {
  //      case Some(_) => true
  //      case _ => false
  //    }
  //
  //    if (valid) Some(payment) else None
  //  }
}

//object PaymentValidationInterpreter {
//  def apply[F]():PaymentValidationInterpreter[F] = new PaymentValidationInterpreter()
//}
//
//
//class PaymentProgram[F[_]: Monad] {
//  def run:F[Payment] = PaymentValidationInterpreter().validate(Payment(Some(1), "John Doe", "Pete Well"))
//}


//new PaymentProgram[Option].run
//trait PaymentSubmissionInterpreter[F[_]] extends PaymentSubmissionAlg[F] {
//  def submit(payment: Payment): F[Payment] = Some(payment)
//}
