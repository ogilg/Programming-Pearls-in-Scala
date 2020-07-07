package Column9

//Implements hash table data structure for integer searching
class HashBag {
  private val N = 10
  private type Node = HashBag.Node

  private def hash(x:Int):Int = x % 10

  //Abstraction function
  //abs(table) = table(h) = {x|hash(x) == h && x in hashtable}
  val table = new Array[Node](N)
  
  def find(x:Int, head:Node):Node = {
    var node = head
    while (node != null && node.datum != x) node = node.next
    node
  }
  
  def contains(x:Int): Boolean = find(x,table(hash(x))) != null
  
  def add (x:Int) : Unit = {
    val h = hash(x)
    table(h) = new Node(x,table(h))
  }
  
  def build(arr:Array[Int]) = {
    for (i <- 0 until arr.size) add(arr(i))
  }
}

object HashBag {
  class Node(val datum:Int,var next:Node)
}

