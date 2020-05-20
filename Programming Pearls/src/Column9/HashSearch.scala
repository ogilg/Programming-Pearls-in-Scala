package Column9

//Implements hash table data structure for integer searching
class HashBag {
  private val N = 10
  private type Node = HashBag.Node
  
  //hash function is mod 10
  private def hash(x:Int):Int = x % 10
  
  //abs(table) = table(h) = {x|hash(x) == h && x in hashtable}
  private val table = new Array[Node](N)
  
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

object HashSearch {
  def main(args:Array[String]):Unit={
    val a = Array(1,3,2,4,6,8,34,32,13,87,89,21,34,56,3,78,96,13,465,798,1,12,87,123)
    val hashtable = new HashBag
    hashtable.build(a)
    println(hashtable.contains(123))
    println(hashtable.contains(928))
  }
}