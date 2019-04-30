package com.tagless

import scala.language.higherKinds

trait PaymentValidationAlg[F[_]] {
  def validate(payment: Payment): F[Payment]
}

trait PaymentSubmissionAlg[F[_]] {
  def submit(payment: Payment): F[Payment]
}


class PaymentValidationInterpreter[F[_]: Option] extends PaymentValidationAlg[F]{

  def validate(payment: Payment): F[Payment] = {
    for {
      v <- validateName(payment)
      a <- validateAmount(payment)
    } yield payment
  }


  private def validateName[F[_]: Option](payment: Payment): F[Payment] = {
    val validName = """[a-zA-z\ ]{1,15}""".r
    val valid = List(payment.beneficiaryName, payment.payerName).foldRight(true)((e, a) => (a && (e match {
      case validName(_*) => true
      case _ => false
    })))

    if (valid ) Some(payment) else None
  }


  private def validateAmount(payment: Payment): F[Payment] = {
    val valid = payment.amount match {
      case Some(_) => true
      case _ => false
    }

    if (valid) Some(payment) else None
  }
}


trait PaymentSubmissionInterpreter[F[_]] extends PaymentSubmissionAlg[F] {
  def submit(payment: Payment): F[Payment] = Some(payment)
}
