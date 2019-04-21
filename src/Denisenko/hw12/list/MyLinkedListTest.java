package denisenko.hw12.list;

import denisenko.hw12.list.MyLinkedList.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<String> testList;

    @Before
    public void initTest() {
        testList = new MyLinkedList<>();
        testList.add("a");
        testList.add("b");
    }

    @Test
    public void testAdd() {

        assertEquals("a", testList.get(0));
    }

    @Test
    public void testAdd1() {
        testList.add("x", 0);
        testList.add("y", 1);
        assertEquals("y", testList.get(1));

    }

    @Test
    public void testAddAll() {

        MyLinkedList<String> test2 = new MyLinkedList<>();
        test2.add("z");
        test2.add("x");
        testList.addAll(test2);
        assertEquals(4, testList.size());
    }

    @Test
    public void testGet() {
        assertEquals("a", testList.get(0));
    }

    @Test
    public void testSet() {
        testList.set("x", 1);
        assertEquals("x", testList.get(1));
    }

    @Test
    public void testRemove() {
        testList.remove(1);
        assertEquals(1, testList.size());
    }

    @Test
    public void testRemove1() {
        testList.remove("b");
        assertEquals(1, testList.size());
    }

    @Test
    public void testSize() {
        assertEquals(2, testList.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(testList.size() == 0);
    }
}