package Column1


class BMap(size:Int) {
    var bitmap:Array[Int] = Array.fill(size)(0)
    
    def add(i:Int):Unit = {
      assert(bitmap(i) ==0)
      bitmap(i) = 1
    }
    
    def mkArray(arr:Array[Int]):Unit = {
      for (i <- 0 until arr.size-1) {
        add(arr(i))
      }
    }
    
    def print : Unit = println(bitmap.mkString(","))
  }

object Bitmap {
  def main(args:Array[String]):Unit = {
    val N = 40
    var arr = (30 to N).toArray
    var bitmap = new BMap(N)
    bitmap.mkArray(arr)
    bitmap.print
  }
}