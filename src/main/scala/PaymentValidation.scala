object PaymentValidation {
  def validate(payment: Payment): Option[Payment] = {
    for {
      v <- validateName(payment)
      a <- validateAmount(payment)
    } yield payment
  }


  private def validateName(payment: Payment): Option[Payment] = {
    val validName = """[a-zA-z\ ]{1,15}""".r
    val valid = List(payment.beneficiaryName, payment.payerName).foldRight(true)((e, a) => (a && (e match {
      case validName(_*) => true
      case _ => false
    })))

    if (valid ) Some(payment) else None
  }


  private def validateAmount(payment: Payment): Option[Payment] = {
    val valid = payment.amount match {
      case Some(_) => true
      case _ => false
    }

    if (valid) Some(payment) else None
  }
}


