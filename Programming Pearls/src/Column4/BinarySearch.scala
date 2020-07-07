package Column4

object BinarySearch {
    //post : returns index of t in array a
  def BSearch(a:Array[Int],target:Int):Int = {
 
    var l = 0; var r = a.length-1
    if(l>r) return -1
    
    while(l<=r){
      //assert((l<0 || a(l) <= target) && (r > a.size-1 || a(r) >= target))
      var m = l + (r-l)/2
      if (a(m) < target) l = m+1
      else if (a(m) == target) return m
      else r = m-1
    }
    -1
  }
}
