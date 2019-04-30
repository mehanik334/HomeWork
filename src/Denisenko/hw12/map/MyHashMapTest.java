package denisenko.hw12.map;

import org.junit.*;


public class MyHashMapTest {

    private MyHashMap<Integer, String> testMap;

    @Before
    public void initTest() {
        testMap = new MyHashMap<>();
        testMap.put(1, "a");
        testMap.put(2, "b");
    }

    @Test
    public void testHash() {
        Integer oneHash = 1;
        int hashOne = Math.abs(oneHash.hashCode() * 16);
        Assert.assertEquals(hashOne, testMap.hash(1));
    }

    @Test
    public void testRaiseSize() {
        int oldSize = testMap.size();
        testMap.raiseSize();
        int newSize = testMap.size();
        Assert.assertEquals(oldSize * 2, newSize);
    }

    @Test
    public void testPut() {
        testMap.put(4, "c");
        Assert.assertEquals("c", testMap.get(4));
    }

    @Test
    public void testGetNode() {
        Assert.assertTrue(testMap.getNode(1) != null);
    }

    @Test
    public void testGet() {
        Assert.assertEquals("a", testMap.get(1));
    }

    @Test
    public void testRemove() {
        Assert.assertEquals("b", testMap.remove(2));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, testMap.size());
    }

    @Test
    public void testClear() {
        testMap.clear();
        Assert.assertEquals(0, testMap.size());
    }
}