package ru.mephi.lab2;
import java.util.Iterator;

// реализация динамического типизированного массива
public class MyTypedList<T> implements Iterable<T> {

    private T[] array;
    private int size = 0;
    private static final double resizeFactor = 1.2;


    // пустой конструктор
    public MyTypedList() {
        array = (T[]) new Object[10];
    }

    // пустой конструктор с заданным размером
    public MyTypedList(int size) {
        if (size <= 0) {
            size = 10;
        }
        array = (T[]) new Object[(int) (size * resizeFactor)];
    }

    // копирующий конструктор
    public MyTypedList(T[] arr) {
        if(arr == null) {
            array = (T[]) new Object[10];
        }
        else {
            size = arr.length;
            array = (T[]) new Object[(int) (size * resizeFactor)];
            System.arraycopy(arr, 0, array, 0, size);
        }
    }

    private void checkResize() {
        if (size == array.length) {
            resize();
        }
    }

    // увеличение размера массива, если весь занят
    private void resize() {
        int newSize = (size < 5) ? 5 : (int) (array.length * resizeFactor);
        T[] newArr = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArr, 0, size);
        array = newArr;
    }

    public void add(T value) {
        if (value == null) {
            return;
        }
        checkResize();
        array[size++] = value;
    }

    // вставляет элемент на данную позицию
    public void add(T value, int index) {
        if (value == null) {
            return;
        }
        checkResize();
        if (index < 0) {
            index = 0;
        }
        else if (index > size) {
            index = size;
        }
        for (int i = size++; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T copy = array[index];
        size--;
        for(int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return copy;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    // возвращает -1, если элемент не найден
    public int indexOf(T value) {
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        if (value == null) {
            return false;
        }
        for (T o : array) {
            if (o == value) {
                return true;
            }
        }
        return false;
    }

    // вставляет элемент вместо другого и возвращает старый элемент, который был по этому индексу
    public T set(T value, int index) {
        if (index < 0 || index >= size || value == null) {
            return null;
        }
        T copy = array[index];
        array[index] = value;
        return copy;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public Iterator<T> iterator() {
        final Iterator<T> iterator = new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }

}
