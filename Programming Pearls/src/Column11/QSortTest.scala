package Column11

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._
import java.util.Arrays

class QSortTest extends TestCase{

  @Test
  def testISort: Unit = {
    val sortableArray = new ArraySorter(Array(1,5,34,7,2,9))
    sortableArray.insertionSort()
    assert(Arrays.equals(Array(1,2,5,7,9,34), sortableArray.arr))
  }


  @Test
  def testPartition: Unit = {
    val sortableArray = new ArraySorter(Array(1,5,34,7,2,9))
    val pivotIndexAfter = sortableArray.partition(0,sortableArray.size)
    var i = 0
    while(i<sortableArray.arr.size) {
      if (i<pivotIndexAfter)
        assert(sortableArray.arr(i)<7)
      else
        assert(sortableArray.arr(i)>=7)
      i+=1
    }
  }

  @Test
  def testQSort: Unit = {
    val sortableArray = new ArraySorter(Array(1,5,34,7,2,9))
    sortableArray.qSort(0,sortableArray.size,0)
    assert(Arrays.equals(Array(1,2,5,7,9,34), sortableArray.arr))
  }

  @Test
  def testQSort2: Unit = {
    val sortableA = new ArraySorter(Array(3,2,1,4,54,23,45,67,42,67,97,90,21,1,23,4,45,7,2,7,67))
    val sortableB = new ArraySorter(Array(3,2,1,4,54,23,45,67,42,67,97,90,21,1,23,4,45,7,2,7,67))
    val sortableC = new ArraySorter(Array(3,2,1,4,54,23,45,67,42,67,97,90,21,1,23,4,45,7,2,7,67))
    sortableA.qSort(0,sortableA.size,0)
    sortableB.insertionSort()
    assert(Arrays.equals(sortableB.arr, sortableA.arr))
    sortableC.combinedSort(4)
    assert(Arrays.equals(sortableB.arr, sortableC.arr))
  }
}
