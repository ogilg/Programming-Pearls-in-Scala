package Column8

object MCS4 {
  def dpMaxContSum(a:Array[Int]):Int = {
    var i = 0
    var maxi = 0; var maxendshere = 0
    
    while (i < a.size) {
      if (maxendshere + a(i) > 0){
        maxendshere += a(i); maxi = maxendshere
      }
      else {
        maxendshere = 0
      }
      i += 1
    }
  maxi
  }
  
  def main(args:Array[String]):Unit = {
    val a = Array(1,4,32,-32,-1,2,32,-8,10,-21,42,-10,31)
    println(dpMaxContSum(a))
  }
}