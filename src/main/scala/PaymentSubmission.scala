object PaymentSubmission {
  def submit(payment: Payment): Option[Payment] = Some(payment)
}
