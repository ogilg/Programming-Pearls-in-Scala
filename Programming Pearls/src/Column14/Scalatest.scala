package Column14

import org.scalacheck._

import org.scalacheck.Prop._

import org.scalacheck.Gen.choose



object Main {
  import org.scalacheck.Gen.choose
  import org.scalacheck.Prop.forAll
  
  val g = choose(-2, 5)
  
  val h = choose(4.1, 4.2)
  
  val p = forAll(h) { n => n >= 4.1 && n <= 4.2 }

}



object Qsqrt extends org.scalacheck.Properties("Sqrt") {
  property("is a root") =
    forAll {n:Int => scala.math.sqrt(n*n) == n}
}