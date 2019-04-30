import org.scalatest.{FunSpec, Inside, Matchers}

class PaymentValidationSpec extends FunSpec with Matchers with Inside {

  describe("#validate") {
    it("returns option with the payment when the payment is valid") {
      val p = Payment(Some(100), "John", "Doe")
      assert(PaymentValidation.validate(p) ==  Some(p))
    }

    it("returns None when the beneficiary or payer is invalid") {
      val p = Payment(Some(100), "JohnJohnJohnJohnJohnJohnJohnJohn", "Doe")
      assert(PaymentValidation.validate(p) ==  None)
    }

    it("returns None when the amount is not present") {
      val p = Payment(None, "JohnJohnJohnJohnJohnJohnJohnJohn", "Doe")
      assert(PaymentValidation.validate(p) ==  None)
    }
  }

}