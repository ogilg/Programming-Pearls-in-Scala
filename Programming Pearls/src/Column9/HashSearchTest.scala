package Column9

import org.junit.{Ignore, Test}
import junit.framework.TestCase
import org.junit.Assert._

class HashSearchTest extends TestCase {

  @Test
  def testHashInit: Unit = {
    val hashTable = new HashBag
    assert(!hashTable.contains(1))
    assertNull(hashTable.table(1))
  }

  @Test
  def testHashAdd: Unit = {
    val hashTable = new HashBag
    assert(!hashTable.contains(2))
    hashTable.add(2)
    assert(hashTable.contains(2))
  }

  @Test
  def testFind: Unit = {
    val hashTable = new HashBag
    hashTable.add(2)
    hashTable.add(12)
    hashTable.add(22)
    val node12 = hashTable.find(12,hashTable.table(2))
    assertEquals(12,node12.datum)
  }

  @Test
  def testBuild: Unit = {
    val a = Array(1,3,2,4,6,8,34,32,13,87,89,21,34,56,3,78,96,13,465,798,1,12,87,123)
    val hashtable = new HashBag
    hashtable.build(a)
    assert(hashtable.contains(56))
    assert(hashtable.contains(96))
    assert(!hashtable.contains(29))
  }
}
