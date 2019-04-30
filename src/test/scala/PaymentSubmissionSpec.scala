import org.scalatest.{FunSpec, Inside, Matchers}

class PaymentSubmissionSpec extends FunSpec with Matchers with Inside {

  describe("#submit") {
    it("returns an option containing the payment") {
      val p = Payment(Some(100), "John", "Doe")
      assert(PaymentSubmission.submit(p) ==  Some(p))
    }
  }

}