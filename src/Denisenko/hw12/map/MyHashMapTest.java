package denisenko.hw12.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(hashOne, testMap.hash(1));
    }

    @Test
    public void testRaiseSize() {
        int oldSize = testMap.size();
        testMap.raiseSize();
        int newSize = testMap.size();
        assertEquals(oldSize * 2, newSize);
    }

    @Test
    public void testPut() {
        testMap.put(4, "c");
        assertEquals("c", testMap.get(4));
    }

    @Test
    public void testGetNode() {
        assertTrue(testMap.getNode(1) != null);
    }

    @Test
    public void testGet() {
        assertEquals("a", testMap.get(1));
    }

    @Test
    public void testRemove() {
        assertEquals("b", testMap.remove(2));
    }

    @Test
    public void testSize() {
        assertEquals(2, testMap.size());
    }

    @Test
    public void testClear() {
        testMap.clear();
        assertEquals(0, testMap.size());
    }


}