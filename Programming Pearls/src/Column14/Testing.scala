package Column14

object Testing {
  def heapTest() = {
    var h = new IntHeap( 20 )
    h.makeHeap(Array(0,2,3,5,6,7,4))
    h.siftUp(6)
    println(h.heap.mkString(","))
    
    h.siftDown(1)
    
    println(h.getRoot)
    
    h.makeHeap(Array(0,10,3,5,6,7,4))
    h.siftDown(1)
    println(h.heap.mkString(","))
    
  }
  
  def main(args:Array[String]) : Unit = {
    heapTest()
  }
}