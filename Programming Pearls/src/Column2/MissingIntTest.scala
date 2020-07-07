package Column2

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._

class MissingIntTest extends TestCase {

  @Test
  def testPartition: Unit = {
    val finder = new MissingIntFinder(Array(1,5,2,6,3,7),15)
    val pivotValue = 4
    val pivotIndexAfter = finder.partition(0,finder.getArraySize,pivotValue)
    for (el <- 0 until finder.getArraySize) {
      if (el<pivotIndexAfter)
        assert(finder.getArray(el)<=pivotValue)
      else
        assert(finder.getArray(el)>pivotValue)
    }
    assertEquals(3,pivotIndexAfter)
  }

  @Test
  def testSwap: Unit = {
    val finder = new MissingIntFinder(Array(1,5,2,6,3,7,14),15)
    finder.swap(0,1)
    finder.swap(2,3)
    assertArrayEquals(finder.getArray, Array(5,1,6,2,3,7,14))
  }

  @Test
  def testMissingInt1: Unit = {
    val finder = new MissingIntFinder(Array(1,5,2,6,3,7,14),15)
    val missing = finder.findMissing
    assert(Array(0,4,8,9,10,11,12,13,15).contains(missing))
  }


  @Test
  def testMissingInt2: Unit = {
    val finder = new MissingIntFinder(Array(1,5,2,0,6,3,7),7)
    val missing = finder.findMissing
    assertEquals(4,missing)
  }

  @Test
  def testMissingInt3 {
    val finder = new MissingIntFinder(Array(5,2,4,3,0,8,1),8)
    val missing = finder.findMissing
    assertEquals(6,missing)
  }
}
