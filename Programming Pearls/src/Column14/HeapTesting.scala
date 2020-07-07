package Column14

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._

class HeapTesting extends TestCase{
  @Test
  def testEmptyPQ: Unit = {
    val pq = new IntPriorityQueue
    assert(pq.isEmpty)
  }

  @Test
  def testisEmpty: Unit = {
    val pq = new IntPriorityQueue
    pq.add(3)
    assert(!pq.isEmpty)
  }

  @Test
  def testClear: Unit = {
    val pq = new IntPriorityQueue
    pq.add(3)
    pq.add(2)
    pq.clear
    assert(pq.isEmpty)
  }

  @Test
  def testExtractMinOnEmptyQueue: Unit = {
    val pq = new IntPriorityQueue
    assert(pq.isEmpty)
    try {
      pq.extractMin
    }
    catch  {
      case e:NullPointerException => assert(true)
      case _ => assert(false)
    }
  }

  @Test
  def testExtractMin: Unit = {
    val pq = new IntPriorityQueue
    pq.add(3)
    assertEquals(3,pq.extractMin)
  }

  @Test
  def testExtractMinSeveralElements: Unit = {
    val pq = new IntPriorityQueue
    pq.add(5)
    pq.add(3)
    pq.add(4)
    assertEquals(3,pq.extractMin)
  }

  @Test
  def testExtractMinDeletesMinFromqueue: Unit = {
    val pq = new IntPriorityQueue
    pq.add(5)
    pq.add(3)
    pq.add(4)
    assertEquals(3,pq.extractMin)
    assertEquals(4,pq.extractMin)
  }

  @Test
  def testPQSize: Unit = {
    val pq = new IntPriorityQueue
    assert(pq.size==0)
    pq.add(5)
    assert(pq.size==1)
    pq.add(3)
    assert(pq.size==2)
    pq.extractMin
    assert(pq.size==1)
    pq.extractMin
    assert(pq.size==0)
  }

}
