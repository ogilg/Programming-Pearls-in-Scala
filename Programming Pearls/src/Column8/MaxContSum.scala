package Column8

object MaxContSum {
  
  def maxSum(a :Array[Int],l:Int,r:Int):Int = {
    
    if (r == l) return 0
    else if (r == l+1) {
      if (a(l)>0) return a(l)
      else return 0
    }
      
    var m = l + (r-l)/2
    val max_left = maxSum(a,l,m)
    val max_right = maxSum(a,m+1,r)
    
    var sum = 0; var lmax = 0
    for (i <- m to l by -1) {
      sum += a(i)
      if (sum > lmax) lmax = sum
    }
    
    sum = 0; var rmax = 0
    for (i <- m+1 until r) {
      sum += a(i)
      if (sum > rmax) rmax = sum
    }
    return Array(max_left,max_right,lmax+rmax).max
  }
  
  
  def main(args:Array[String]):Unit = {
    val a = Array(1,4,32,-32,-1,2,32,-8,10,-21,42,-10,31)
    println(maxSum(a,0,a.size))
  }
}
