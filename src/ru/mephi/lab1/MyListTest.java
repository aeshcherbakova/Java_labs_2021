package ru.mephi.lab1;

import static org.junit.Assert.*;

public class MyListTest {

    @org.junit.Test
    public void add() {
        MyList a = new MyList(1);
        a.add(1337);
        a.add(-42);
        a.add(null);
        a.add(0);
        Object[] expected = {1337, -42, 0};
        assertEquals(new MyList(expected), a);
    }

    @org.junit.Test
    public void testAdd() {
        MyList a = new MyList(3);
        // выходим за границы индексов
        a.add(1337, -100);
        a.add(42, 42);
        a.add(-98, 0);
        a.add(null, 2);
        a.add(0, 1);
        a.add(8709, 3);
        a.add(-9, 2);
        Object[] expected = {-98, 0, -9, 1337, 8709, 42}; // дважды сработает ресайз
        assertEquals(new MyList(expected), a);
    }

    @org.junit.Test
    public void remove() {
        MyList a = new MyList(new Object[]{"hello", 1337, "WoRlD", -0.234, 'q', true});
        assertNull(a.remove(-5));
        assertNull(a.remove(a.size()));
        assertEquals(1337, a.remove(1));
        assertEquals('q', a.remove(3));
        assertEquals(4, a.size());
    }

    @org.junit.Test
    public void get() {
        MyList a = new MyList(new Object[]{"hello", 1337, "WoRlD", -0.234, 'q', true});
        assertNull(a.get(-5));
        assertNull(a.get(a.size()));
        assertEquals("hello", a.get(0));
        assertEquals(true, a.get(a.size()-1));
        a.add("end");
        assertEquals("end", a.get(a.size()-1));
    }

    @org.junit.Test
    public void indexOf() {
        MyList a = new MyList(new Object[]{"hello", 1337, "WoRlD", -0.234, 'q', true});
        assertEquals(-1, a.indexOf(null));
        assertEquals(-1, a.indexOf(1234));
        assertEquals(0, a.indexOf("hello"));
        assertEquals(4, a.indexOf('q'));
        a.set('w', 4);
        assertEquals(-1, a.indexOf('q'));
    }

    @org.junit.Test
    public void contains() {
        Object[] init = {"hello", 1337, "WoRlD", -0.234, 'q', true};
        MyList a = new MyList(init);
        assertTrue(a.contains("hello"));
        assertTrue(a.contains(true));
        assertFalse(a.contains(-1337));
        assertFalse(a.contains(-0.235));
    }

    @org.junit.Test
    public void set() {
        Object[] init = {"hello", 1337, "WoRlD", -0.234, 'q', true};
        MyList a = new MyList(init);
        assertEquals("WoRlD", a.set("world", 2));
        assertNull(a.set(null, 3));
        assertNull(a.set(5, 10));
        assertNull(a.set(5, -1));
        assertEquals(true, a.set(false, 5));

        Object[] expected = {"hello", 1337, "world", -0.234, 'q', false}; // дважды сработает ресайз
        assertEquals(new MyList(expected), a);
    }

    @org.junit.Test
    public void size() {
        Object[] init = {"hello", 1337, "WoRlD", -0.234, 'q', true};
        MyList a = new MyList(init);
        assertEquals(6, a.size());
        a.add(567, 324);
        a.add("hello");
        assertEquals(8, a.size());
        a.remove(4);
        assertEquals(7, a.size());
    }

    @org.junit.Test
    public void isEmpty() {
        MyList a = new MyList();
        assertTrue(a.isEmpty());
        a.add(0);
        assertFalse(a.isEmpty());
        a.remove(0);
        assertTrue(a.isEmpty());
    }
}