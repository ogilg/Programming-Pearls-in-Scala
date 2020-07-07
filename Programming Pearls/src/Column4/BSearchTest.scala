package Column4

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._

class BSearchTest extends TestCase{

  @Test
  def testBsearch: Unit = {
    val index = BinarySearch.BSearch(Array(1,4,7,12,16,24,37,124),12)
    assertEquals(3,index)
  }

  @Test
  def testBsearchLast: Unit = {
    val index = BinarySearch.BSearch(Array(1,4,7,12,16,24,37,124),124)
    assertEquals(7,index)
  }

  @Test
  def testBsearchFirst: Unit = {
    val index = BinarySearch.BSearch(Array(1,4,7,12,16,24,37,124),1)
    assertEquals(0,index)
  }

  @Test
  def testBsearchNotInArray: Unit = {
    val index = BinarySearch.BSearch(Array(1,4,7,12,16,24,37,124),13)
    assertEquals(-1,index)
  }

}
