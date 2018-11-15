import org.scalatest.{FunSpec, Inside, Matchers}

class FakeSpec extends FunSpec with Matchers with Inside {

  describe("sum 1+1") {
    it("returns 2") { assert(1+1 == 2)}
  }
}

