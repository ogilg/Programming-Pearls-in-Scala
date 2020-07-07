package Column11

class ArraySorter(a:Array[Int]) extends ArrayOps(a) {
  val arr:Array[Int] = a
  val size :Int = a.length


  def insertionSort() : Unit ={
    var shiftIndex = 1

    def shiftDownwards: Unit = {
      a(shiftIndex) = a(shiftIndex - 1)
      shiftIndex -= 1
    }

    for (indexUpwards <- 1 until a.length){
      var value = a(indexUpwards)
      shiftIndex = indexUpwards
      while (shiftIndex>0 && a(shiftIndex-1) >value)
        shiftDownwards
      a(shiftIndex) = value
    }
  }

  def qSort(l:Int,r:Int,cutoff:Int) :Unit={

    if (r-l <= cutoff) return
    val pivotIndexAfter = partition(l,r)
    qSort(l,pivotIndexAfter,cutoff)
    qSort(pivotIndexAfter+1,r,cutoff)
  }

  def combinedSort(cutoff:Int) : Unit = {
    qSort(0,a.length,cutoff)
    insertionSort()
  }
}
