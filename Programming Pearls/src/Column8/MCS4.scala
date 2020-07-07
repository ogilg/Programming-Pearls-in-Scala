package Column8

object MCS4 {
  def dpMaxContSum(a:Array[Int]):Int = {
    var max = 0; var maxEndsHere = 0
    
     for (el <- a) {
      if (maxEndsHere + el > 0){
        maxEndsHere += el
        if (maxEndsHere > max)
          max = maxEndsHere
      }
      else
        maxEndsHere = 0
    }
  max
  }
}