package Column13

object RandInts {
  
  def main(args:Array[String]):Unit={
    genRandInts(100,10)
    
  }
  
  //generates m random integers in range [0..n]
  def genRandInts(n:Int,m:Int) : Array[Int] = {
    import scala.collection.mutable.HashSet
    assert(m<n)
    val r = scala.util.Random; var t =0
    var out = new Array[Int](m); var set = new HashSet[Int]
    
    for (j <- (n-m) until n) {
      t = java.lang.Math.floorMod(r.nextInt(),(j+1))
      if (set.contains(t)) set += j
      else set += t
    }
    println(s"this is the set: $set")
    out
  }
  
  
}