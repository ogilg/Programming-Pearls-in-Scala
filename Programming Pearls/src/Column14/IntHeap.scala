package Column14

// arr(0) entry is disregarded
// Recommend padding for adding elements
class IntHeap(MaxSize:Int) extends Heap[Int] {
  
  var heap : Array[Int] = new Array[Int](MaxSize)
  
  def clear = {heap = new Array[Int](MaxSize); size_ = 1}
  
  // adjust for first element wasted
  def size = size_ - 1

  def getSize = size_ -1
  
  var size_ = 1
  
  //creates heap and stores it in heap variable as an array
  def makeHeap(arr:Array[Int]) : Unit = {
    assert(arr.size > 0)
    size_ = 1
    for (i <- 0 until arr.size) {
      addToHeap(arr(i))
    }
  }
  
  //updates heap with new element x
  def addToHeap(x:Int) : Unit = {
    assert(size < MaxSize)
    heap(size_) = x
    size_ += 1
    siftUp(size_ - 1)
  }
  
  // deletes from position
  def deleteFromHeap(pos:Int) : Unit  = {
    heap(pos) = heap(size_ - 1)
    size_ -= 1
    if (heap(pos) > parent(pos))
      siftUp(pos)
    else
      siftDown(pos)
  }
  
  
  def getRoot : Int = heap(1)
  
  //returns index of left child of node i
  def lchild(i:Int) : Int = 2*i
  
  //returns index of right child of node i
  def rchild(i:Int) : Int = 2*i + 1
  
  //returns parent of node i
  def parent(i:Int) : Int = i /2
  
  def swap(i:Int, j:Int) : Unit = {val temp = heap(i); heap(i) = heap(j) ; heap(j) = temp}
  
  // min-heapify up
  //post: heap property
  def siftUp(pos:Int) : Unit = {
    var i = pos
    // Inv: heap property holds everywhre except perhaps between i and its parents
    while (i > 1 && heap(parent(i)) > heap(i)) {swap(i,parent(i)); i = parent(i)}
  }
  
  //min-heapify down
  //post: heap property
  def siftDown(pos:Int) : Unit = {
    var i = pos
    // heap property holds except perhaps between i and its children
    while(i < (size_ /2) && (heap(i) > lchild(i) || heap(i) > rchild(i))) {
      if (rchild(i) > lchild(i)) {
        swap(i,lchild(i))
        i = lchild(i)
      }
      else {
        swap(i,rchild(i))
        i = rchild(i)
      }
    }
  }
  
  
}