package Column1


class BMap(startSize:Int) {
  var bitmap:Array[Int] = Array.fill(startSize)(0)
  var size = 0

  def emptyBitMap(): Unit = {
    bitmap = Array.fill(startSize)(0)
    size = 0
  }

  def contains(i:Int): Boolean = bitmap(i)==0

  def add(i:Int):Unit = {
    assert(size<startSize)
    if (bitmap(i) ==0) {bitmap(i) = 1; size+=1}
  }

    def remove(i:Int):Unit = {
    if (bitmap(i)==1) {bitmap(i) =0; size-=1}
  }

  def mkArray(arr:Array[Int]):Unit = {
    require(arr.length<=startSize)
    emptyBitMap()
    for (i <- 0 until arr.length-1) {
      add(arr(i))
    }
  }
    
  def print : Unit = println(bitmap.mkString(","))
}

