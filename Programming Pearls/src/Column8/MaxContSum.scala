package Column8

class MaxContSum(a:Array[Int]) {

  //Divide and Conquer
  def maxSum(l:Int,r:Int):Int = {
    if (r == l) return 0
    else if (r == l+1) {
      return oneElementSum(l)
    }
      
    var m = (r+l)/2
    val max_left = maxSum(l,m)
    val max_right = maxSum(m+1,r)

    var combined = getCombined(l,r,m)

    Array(max_left,max_right,combined).max
  }


  private def getCombined(l: Int, r: Int, m: Int) = {
    var lmax = getMaxSumDown(l, m)
    var rmax = getMaxSumUp(m + 1, r)
    lmax + rmax
  }

  private def oneElementSum(l: Int): Int = {
    if (a(l) > 0) a(l)
    else 0
  }

  def getMaxSumUp(l:Int,r:Int): Int = {
    var sum = 0
    var max = 0
    for (i <- l until r) {
      sum += a(i)
      if (sum > max) max = sum
    }
    max
  }

  def getMaxSumDown(l:Int,r:Int): Int = {
    var sum = 0
    var max = 0
    for (i <- r to l by -1) {
      sum += a(i)
      if (sum > max) max = sum
    }
    max
  }
}
