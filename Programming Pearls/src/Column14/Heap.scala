package Column14

//State: heap = seq[T]
// Init: h = []

//binary heap 
trait Heap[T] {
  
  def makeHeap(arr:Array[T])
  
  //Maintains min-heap property
  def siftUp(i:Int) : Unit
  
  def siftDown(i:Int) : Unit
  
  def getRoot : T 
  //returns index of left child of node i
  def lchild(i:Int) : Int 
  
  //returns index of right child of node i
  def rchild(i:Int) : Int 
  
  //returns parent of node i
  def parent(i:Int) : Int 
}