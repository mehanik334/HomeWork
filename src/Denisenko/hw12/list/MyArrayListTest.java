package denisenko.hw12.list;

import denisenko.hw4.MyList;
import org.junit.*;

public class MyArrayListTest {

    private MyArrayList<String> listTest;

    @Before
    public void initTest() {
        listTest = new MyArrayList<String>();
        listTest.add("a");
        listTest.add("b");
        listTest.add("c");
    }

    @Test
    public void testAdditionSize() {
        listTest.additionSize();
        Assert.assertEquals(10, listTest.getCapasity());
    }

    @Test
    public void testAdd() {
        Assert.assertEquals("a", listTest.get(0));
    }

    @Test
    public void testAdd1() {
        listTest.add("d", 3);
        Assert.assertEquals("d", listTest.get(3));
    }

    @Test
    public void testAddAll() {
        MyList<String> test2 = new MyArrayList<>();
        test2.add("z");
        test2.add("x");
        test2.add("v");
        listTest.addAll(test2);
        Assert.assertEquals(3, listTest.size());
    }

    @Test
    public void testGet() {
        String getFromList = listTest.get(0);
        Assert.assertEquals("a", getFromList);
    }

    @Test
    public void testSet() {
        listTest.set("w", 1);
        Assert.assertEquals("w", listTest.get(1));
    }

    @Test
    public void testRremove() {
        listTest.remove(1);
        Assert.assertTrue(listTest.size() == 2);
    }

    @Test
    public void testRemove1() {
        listTest.remove("a");
        Assert.assertTrue(listTest.size() == 2);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(3, listTest.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(listTest.size() == 0);
    }
}