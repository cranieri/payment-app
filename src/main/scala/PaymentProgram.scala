object PaymentProgram {

  def run(payment: Payment): Option[Payment] = {
    for {
      p <- PaymentValidation.validate(payment)
      s <- PaymentSubmission.submit(p)
    } yield s
  }
}