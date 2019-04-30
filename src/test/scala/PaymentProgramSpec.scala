import org.scalatest.{FunSpec, Inside, Matchers}

class PaymentProgramSpec extends FunSpec with Matchers with Inside {

  describe("#run") {
    it("returns the payment if the payment is valid") {
      val p = Payment(Some(100), "John", "Doe")
      assert(PaymentProgram.run(p) ==  Some(p))
    }

    it("returns None if the payment is not valid") {
      val p = Payment(Some(100), "JohnJohnJohnJohnJohnJohnJohn", "Doe")
      assert(PaymentProgram.run(p) ==  None)
    }
  }

}