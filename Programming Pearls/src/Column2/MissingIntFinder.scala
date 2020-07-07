package Column2

 // N is maximum value of range
class MissingIntFinder(a:Array[Int], N:Int) {
   assert(a.length <= N) // there has to be a missing int in the range [0,N]

  def findMissing:Int={
    //Use binary search to cut the search space in half every time
    var l = 0; var r = a.length
    var lowerBound = 0; var upperBound = N
    
    while(lowerBound<upperBound && l<r-1) {
      var pivotValue = lowerBound + (upperBound - lowerBound)/2
      var pivotIndexAfter = partition(l,r,pivotValue)
      if (pivotIndexAfter<=pivotValue)
        {r=pivotIndexAfter;upperBound=pivotValue}
      else
        {l = pivotIndexAfter;lowerBound=pivotValue+1}
    }
    if(lowerBound==a(l)) upperBound else lowerBound
  }
  
  def partition(l:Int, r:Int, pivotValue:Int) : Int = {
    var i = l; var j = r-1

    while(i<j) {
      if(a(i) > pivotValue) {swap(i,j); j-=1}
      else { i+= 1}
    }
    i
  }
  
  def swap(i:Int, j:Int) {
    val temp = a(i); a(i) = a(j); a(j) = temp
  }
     
  def getArray : Array[Int] = a

  def getArraySize :Int = a.length
}




