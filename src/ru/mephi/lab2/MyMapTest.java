package ru.mephi.lab2;
import org.junit.Test;
import ru.mephi.lab1.MyList;

import static org.junit.Assert.*;

public class MyMapTest {

    Object[] keys   = { "hello", "hahahah", '8', 0, '?',   1234, true };
    Object[] values = { 5,       -42.5,     "8", 0, -10.0, 1234, false };

    private MyMap init() {
        MyMap map = new MyMap();
        for(int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    @Test
    public void put() {
        MyMap map = init();
        map.put("hello", "changed");
        map.put(true, true);
        map.put(null, "not null");
        Object[] changedValues = { "changed", -42.5, "8", 0, -10.0, 1234, true };
        assertEquals(new MyList(changedValues), map.getValues());
    }

    @Test
    public void get() {
        MyMap map = init();

        for(int i = 0; i < keys.length; i++) {
            assertEquals(values[i], map.get(keys[i]));
        }

        assertNull(map.get("Hello"));
        assertNull(map.get(new MyMap()));
    }

    @Test
    public void testGet() {
        MyMap map = init();

        assertEquals(555, map.get("Hello", 555));
        assertEquals("Not found", map.get('a', "Not found"));
        map.put('a', "Found");
        assertEquals("Found", map.get('a', "Not found"));
    }

    @Test
    public void remove() {
        MyMap map = init();

        assertEquals("8", map.remove('8'));
        assertNull(map.remove("Hello"));
        assertEquals(-10.0, map.remove('?'));

        Object[] newKeys   = { "hello", "hahahah", 0, 1234, true };
        Object[] newValues = { 5,       -42.5,     0, 1234, false };

        assertEquals(newKeys.length, map.size());
        for(int i = 0; i < newKeys.length; i++) {
            assertEquals(newValues[i], map.get(newKeys[i]));
        }
    }

    @Test
    public void keyContains() {
        MyMap map = init();
        assertTrue(map.keyContains(true));
        assertTrue(map.keyContains(0));
        assertTrue(map.keyContains("hello"));
        assertFalse(map.keyContains(false));

        map.remove("hello");
        assertFalse(map.keyContains("hello"));
    }

    @Test
    public void getKeys() {
        MyMap map = init();
        assertEquals(new MyList(keys), map.getKeys());

        map.put("new", "new");
        map.remove('8');
        Object[] newKeys = { "hello", "hahahah", 0, '?', 1234, true, "new" };
        assertEquals(new MyList(newKeys), map.getKeys());
    }

    @Test
    public void getValues() {
        MyMap map = init();
        assertEquals(new MyList(keys), map.getKeys());

        map.put("new", "new");
        map.remove('8');
        Object[] newValues = { 5, -42.5, 0, -10.0, 1234, false, "new" };
        assertEquals(new MyList(newValues), map.getValues());
    }

    @Test
    public void getEntries() {
        MyMap map = init();
        MyList expected = new MyList();
        for(int i = 0; i < keys.length; i++) {
            expected.add(new Pair(keys[i], values[i]));
        }
        assertEquals(expected, map.getEntries());

    }

    @Test
    public void size() {
        MyMap map = new MyMap();
        assertEquals(0, map.size());

        map = init();
        assertEquals(keys.length, map.size());

        map.remove(true);
        map.remove('8');
        assertEquals(keys.length - 2, map.size());
    }

    @Test
    public void isEmpty() {
        MyMap map = new MyMap();
        assertTrue(map.isEmpty());

        map.put(5, 5);
        map.put(true, false);
        assertFalse(map.isEmpty());

        map.remove(5);
        map.remove(true);
        assertTrue(map.isEmpty());
    }


}
