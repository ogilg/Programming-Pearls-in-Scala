package Column11

//proto-Array class for writing sorting and partitioning algorithms
class Ar(a:Array[Int]) {
  val size = a.size
  val arr = a
  
  def bestIndex(l:Int,r:Int) : Int = {
    //Pre: r > l and r < size
    val m = l + (r-l)/2
    
    if (a(m) >= a(l)){
      if (a(m) <= a(r-1)) return m
      else if (a(l) <= a(r-1)) return r-1
      else return l
    }
    else {
      if(a(m) >= a(r-1)) return m
      else if(a(l) >= a(r-1)) return r-1
      else return l
    }
  }
  
  def swap(i:Int,j:Int) : Unit = {
    val temp = a(i); a(i) = a(j); a(j) = temp
  }
  
  def partition(l:Int,r:Int) : Int = {
    
    var p = bestIndex(l,r)
    println(s"partitioning with ${a(p)}")
    val x = a(p)
    swap(p,r-1)
    
    var i = l; var j = r-2
    
    //Inv: l <= i <= j <= r-2
    // and a[l..i) < x and a[j..r-1) >= x
    while(i<j+1){
      if(a(i) < x) i+=1
      else swap(i,j); j-=1
    }
    //if (a(i) > x) swap(i,r-1)
    //else {swap(i+1,r-1); i+=1}
    
    i
  }
  
  def qsort(l:Int,r:Int,cutoff:Int) :Unit={
    
    if (r-l < cutoff) return
    val k = partition(l,r)
    qsort(l,k-1,cutoff)
    qsort(k+1,r,cutoff)
  }
  
  def isort = {
    var j = 1
    for (i <- 1 until size){
      var t = a(i)
      j = i
      while (j>0 && a(j-1) >t) {a(j) = a(j-1);j-=1}
      a(j) = t
    }
  }
}
