package Column8

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._

class MaxContSumTest extends TestCase{

  @Test
  def testAllPositive: Unit = {
    val arr = Array(1,2,3,4,5,6)
    val mcs = new MaxContSum(arr)

    assertEquals(arr.sum,mcs.maxSum(0,arr.length))
  }

  @Test
  def testgetMaxSum: Unit = {
    val arr = Array(1,-2,3,4,5,6)
    val mcs = new MaxContSum(arr)
    assertEquals(3,mcs.getMaxSumDown(0,2))
    assertEquals(15,mcs.getMaxSumUp(3,6))
  }
  
  @Test
  def testMCS1: Unit = {
    val arr = Array(1,2,3,-3,5,6)

    val mcs = new MaxContSum(arr)
    assertEquals(3,mcs.getMaxSumDown(0,3))
    assertEquals(arr.sum,mcs.maxSum(0,arr.length))
  }

  @Test
  def testMCSEdge: Unit = {
    val arr = Array(-1,2,3,3,5,6)
    val mcs = new MaxContSum(arr)
    assertEquals(arr.sum+1,mcs.maxSum(0,arr.length))
  }

  @Test
  def testMCSLong: Unit = {
    val arr = Array(1,4,32,-32,-1,2,32,-8,10,-21,42,-10,-31)
    val mcs = new MaxContSum(arr)
    assertEquals(arr.sum+41,mcs.maxSum(0,arr.length))
  }

  @Test
  def testDPMCS: Unit = {
    val arr = Array(1,4,32,-32,-1,2,32,-8,10,-21,42,-10,-31)
    assertEquals(arr.sum+41,MCS4.dpMaxContSum(arr))
  }

  @Test
  def testDPMCS2: Unit = {
    val arr = Array(1,4,32,-32)
    assertEquals(arr.sum+32,MCS4.dpMaxContSum(arr))
  }
}
