package Column11
//Supports useful array operations for sorting
class ArrayOps(a:Array[Int]) {

  def bestIndex(l:Int,r:Int) : Int = {
    //Pre: r > l and r < size
    val m = getMid(l, r)

    if (elementBigger(r-1,l)){
      if (elementBigger(r-1,m)) m
      else if (elementBigger(r-1,l)) r-1
      else l
    }
    else {
      if(elementBigger(r - 1, m)) m
      else if(elementBigger(r - 1, l)) r-1
      else l
    }
  }

  private def elementBigger(r: Int, l: Int) = {
    a(r) >= a(l)
  }

  private def getMid(l: Int, r: Int) = {
    l + (r - l) / 2
  }

  private def swap(i:Int,j:Int) : Unit = {
    val temp = a(i); a(i) = a(j); a(j) = temp
  }

  def partition(l:Int,r:Int) : Int = {
    var pivotIndex = bestIndex(l,r)
    //println(s"partitioning with ${a(p)}")
    val pivot = a(pivotIndex)
    swap(pivotIndex,r-1)

    var i = l; var j = r-2
    //Inv: l <= i <= j <= r-2
    // and a[l..i) < x and a[j..r-1) >= x
    while(i<=j){
      if(a(i) < pivot) i+=1
      else {swap(i,j); j-=1}
    }
    getPivotIndexAfter(r, pivot, i)
  }

  private def getPivotIndexAfter(r: Int, pivot: Int, i: Int): Int = {
    if (a(i) >= pivot) {
      swap(i, r - 1)
      i
    } else {
      swap(i + 1, r - 1)
      i +1
    }
  }
}
