package Column1

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._

class BitMapTests extends TestCase {

  @Test
  def testSizeZero {
    val bmap = new BMap(0)
    assertEquals(bmap.size,0)
  }

  @Test
  def addInt: Unit = {
    val bmap = new BMap(4)
    bmap.add(2)
    assertEquals(bmap.bitmap(3),1)
  }

  @Test
  def sizeUpdatesWhenAdding: Unit = {
    val bmap = new BMap(5)
    bmap.add(2)
    assertEquals(bmap.size,1)
    bmap.add(3)
    assertEquals(bmap.size,2)
    bmap.add(2)
    assertEquals(bmap.size,2)
  }

  @Test
  def sizeUpdatesWhenRemoving: Unit = {
    val bmap = new BMap(5)
    bmap.add(2)
    assertEquals(bmap.size,1)
    bmap.remove(2)
    assertEquals(bmap.size,0)
    bmap.remove(2)
    assertEquals(bmap.size,0)
  }

  @Test
  def makeArrayWorks: Unit = {
    val bmap = new BMap(40)
    val arr = Array(1,4,12,25,36)
    bmap.mkArray(arr)
    for (el <- arr) {
      assert(bmap.contains(el))
    }
  }

}
