package ru.sber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {
    private MyList<String> myList;

    @Before
    public void init() {
        myList = new MyList<>();
    }

    @Test
    public void isExist() {
        assertNotNull(myList);
    }

    @Test
    public void sizeTest() {
        assertEquals(0, myList.size());
    }

    @Test
    public void addTest() {
        myList.add("f");
        myList.add("h");
        myList.add("g");
        assertEquals(3, myList.size());
    }

    @Test
    public void removeTest() {
        assertFalse(myList.remove());

        myList.add("a");
        assertTrue(myList.remove());
        assertEquals(0, myList.size());

        myList.add("a");
        myList.add("b");
        myList.add("c");

        assertTrue(myList.remove());
        assertEquals(2, myList.size());
    }

    @Test
    public void getTest() {
        assertNull(myList.get());

        myList.add("a");
        assertEquals(myList.get(),"a");

        myList.add("b");
        myList.add("c");
        assertEquals(myList.get(),"a");
    }

    @Test
    public void getLastTest() {
        assertNull(myList.getLast());

        myList.add("a");
        assertEquals(myList.getLast(),"a");

        myList.add("b");
        myList.add("c");
        assertEquals(myList.getLast(),"c");
    }

    @Test
    public void removeLastTest() {
        assertFalse(myList.removeLast());

        myList.add("a");
        assertTrue(myList.removeLast());
        assertEquals(0, myList.size());

        myList.add("a");
        myList.add("b");
        myList.add("c");

        assertTrue(myList.removeLast());
        assertEquals(2, myList.size());
    }

    @Test
    public void addReverseTest() {
        myList.addReverse("c");
        myList.addReverse("b");
        myList.addReverse("a");
        assertEquals("a", myList.get());
        assertEquals("c", myList.getLast());
        assertEquals(3, myList.size());
    }
}
