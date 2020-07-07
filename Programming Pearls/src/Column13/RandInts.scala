package Column13

import scala.collection.mutable.HashSet

object RandInts {
  
  def main(args:Array[String]):Unit={
    genRandInts(100,10)
  }
  
  //generates m random integers in range [0..n]
  def genRandInts(n:Int,m:Int) : Array[Int] = {
    assert(m<n)
    val randomGenerator = scala.util.Random
    var generatedRandInts = new Array[Int](m)
    var set = new HashSet[Int]

    def generateRandomInt(j: Int) = {
      java.lang.Math.floorMod(randomGenerator.nextInt(), j + 1)
    }

    def updateSet(j: Int, randInt: Int) = {
      if (set.contains(randInt)) set += j
      else set += randInt
    }

    for (j <- (n-m) until n) {
      var randInt = generateRandomInt(j)
      updateSet(j, randInt)
    }
    println(s"this is the set: $set")
    generatedRandInts
  }
  
  
}