package Column14

//state: bag : Power bag T
// Init : bag = {||}

trait PQ[T] {
  
  def isEmpty : Boolean
  
  //Pre: non-empty
  // post: returns and deleted minimum
  def extractMin : T
  
  def add(elem:T) : Unit
  
  def clear : Unit
}