package Column11

import Column11.Ar

object Qsort {
  //combination of quick sort for general orering and insertion sort for cleaning up to achieve quicker sorting
  def goodsort(a:Ar,cutoff:Int) : Unit ={
    a.qsort(0,a.size,cutoff)
    a.isort
  }
  
  
  def main(args:Array[String]):Unit = {
    val a = new Ar(Array(3,2,1,4,54,23,45,67,42,67,97,90,21,1,23,4,45,7,2,7,67))
    val cutoff = 3
    goodsort(a,cutoff)
    println(a.arr.mkString(","))
  }
}