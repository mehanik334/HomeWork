package denisenko.hw12.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<String> s;

    @Before
    public void initTest() {
        s = new MyArrayList<String>();
        s.add("a");
        s.add("b");
        s.add("c");
    }

    @Test
    public void testAdditionSize() {
        s.additionSize();
        assertEquals(10, s.getCapasity());
    }

    @Test
    public void testAdd() {
        assertEquals("a", s.get(0));
    }

    @Test
    public void testAdd1() {
        s.add("d", 3);
        assertEquals("d", s.get(3));
    }

    @Test
    public void testAddAll() {

        MyArrayList<String> test2 = new MyArrayList<>();
        test2.add("z");
        test2.add("x");
        test2.add("v");
        s.addAll(test2);
        assertEquals(3, s.size());
    }

    @Test
    public void testGet() {
        String v = s.get(0);
        assertEquals("a", v);
    }

    @Test
    public void testSet() {
        s.set("w", 1);

        assertEquals("w", s.get(1));
    }

    @Test
    public void testRremove() {

        s.remove(1);
        assertTrue(s.size() == 2);
    }


    @Test
    public void testRemove1() {
        s.remove("a");

        assertTrue(s.size() == 2);
    }

    @Test
    public void testSize() {

        assertEquals(3, s.size());
    }

    @Test
    public void testIsEmpty() {

        assertFalse(s.size() == 0);

    }
}