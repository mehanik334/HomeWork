package denisenko.hw12.list;

import org.junit.*;


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
        Assert.assertEquals("a", testList.get(0));
    }

    @Test
    public void testAdd1() {
        testList.add("x", 0);
        testList.add("y", 1);
        Assert.assertEquals("y", testList.get(1));
    }

    @Test
    public void testAddAll() {
        MyLinkedList<String> test2 = new MyLinkedList<>();
        test2.add("z");
        test2.add("x");
        testList.addAll(test2);
        Assert.assertEquals(4, testList.size());
    }

    @Test
    public void testGet() {
        Assert.assertEquals("a", testList.get(0));
    }

    @Test
    public void testSet() {
        testList.set("x", 1);
        Assert.assertEquals("x", testList.get(1));
    }

    @Test
    public void testRemove() {
        testList.remove(1);
        Assert.assertEquals(1, testList.size());
    }

    @Test
    public void testRemove1() {
        testList.remove("b");
        Assert.assertEquals(1, testList.size());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, testList.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testList.size() == 0);
    }
}