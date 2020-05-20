package Column2

 // N is maximum value of range
class Finder(a:Array[Int],N:Int) {
  
  val size = a.size
  
  def findMissing:Int={
    //Use binary search to cut the search space in half every time
    
    var l = 0; var r = a.size
    var lower = 1; var upper = N
    
    while(lower<upper && l<r-1) {
      var p = (lower + (upper - lower)/2)
      var k = partition(l,r,p)+1
      if (k<p) {r=k;upper=p}
      else {l = k;lower=p+1}
    }
    
    if(lower==a(l)) upper else lower
  }
  
  def partition(l:Int,r:Int,p:Int) : Int = {
    var i = l; var j = r-1
    
    while(i<j) {
      if(a(i) > p) {swap(i,j); j-=1}
      else { i+= 1}
    }
    i
  }
  
  def swap(i:Int, j:Int) {
    val temp = a(i); a(i) = a(j); a(j) = temp
  }
     
  def array : Array[Int] = a
}

object MissingInt {
  def main(args:Array[String]):Unit={
    val arr = new Finder(Array(1,6,6,6,5,8),9)
    //println(arr.partition(0,arr.size,5))
    println(arr.findMissing)
    
  }
  

}