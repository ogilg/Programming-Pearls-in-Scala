package Column14

//uses a heap internally
class IntPriorityQueue extends PQ[Int] {
  
  val MAX = 20
  
  var minHeap = new IntHeap(MAX)

  def size: Int = minHeap.getSize
  
  def makePQ(arr:Array[Int]) : Unit = minHeap.makeHeap(arr)  
  
  def isEmpty : Boolean = minHeap.size == 0
  
  def clear : Unit = minHeap.clear
  
  def add(x:Int) : Unit = minHeap.addToHeap(x)
  
  def extractMin : Int = {
    if (minHeap.getSize == 0)
      throw new NullPointerException("Heap is empty")
    val min = minHeap.getRoot
    minHeap.deleteFromHeap(1)
    min
  }
}