package ru.mephi.lab3;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntListTest {

    @Test
    public void merge() {
        int[] x = { -100, -45, 0, 1, 2, 42, 50, 100 };
        int[] y = { -99, -45, 0, 3, 5, 55, 1337 };
        int[] result = { -100, -99,-45, -45, 0, 0, 1, 2, 3, 5, 42, 50, 55, 100, 1337 };
        IntList xList = new IntList(x);
        IntList yList = new IntList(y);
        assertEquals(xList.merge(yList), new IntList(result));
    }
}