package ru.mephi.lab1;

// реализация динамического массива
public class MyList {

    private Object[] array;
    private int size = 0;
    private static double resizeFactor = 1.2;


    // пустой конструктор
    public MyList() {
        array = new Object[10];
    }

    // пустой конструктор с заданным размером
    public MyList(int size) {
        array = new Object[(int) (size * resizeFactor)];
    }

    // копирующий конструктор
    public MyList(Object[] arr) {
        if (arr == null)
            array = new Object[10];
        else {
            size = arr.length;
            this.array = new Object[(int) (size * resizeFactor)];
            System.arraycopy(arr, 0, this.array, 0, size);
        }
    }

    private void checkResize() {
        if (size == array.length)
            resize();
    }

    // увеличение размера массива, если весь занят
    private void resize() {
        int newSize = (size < 5) ? 5 : (int) (array.length * resizeFactor);
        Object[] newArr = new Object[newSize];
        System.arraycopy(array, 0, newArr, 0, size);
        this.array = newArr;
    }

    public void add(Object value) {
        if (value == null) return;
        checkResize();
        array[size++] = value;
    }

    // вставляет элемент на данную позицию
    public void add(Object value, int index) {
        if (value == null) return;
        checkResize();
        if (index < 0) index = 0;
        else if (index > size) index = size;
        for (int i = size++; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) return null;
        Object copy = array[index];
        size--;
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        return copy;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) return null;
        return array[index];
    }

    // возвращает -1, если элемент не найден
    public int indexOf(Object value) {
        if (value == null) return -1;
        for (int i = 0; i < size; i++)
            if (array[i] == value) return i;
        return -1;
    }

    public boolean contains(Object value) {
        if (value == null) return false;
        for (Object o : array)
            if (o == value) return true;
        return false;
    }

    // вставляет элемент вместо другого и возвращает старый элемент, который был по этому индексу
    public Object set(Object value, int index) {
        if (index < 0 || index >= size || value == null) return null;
        Object copy = array[index];
        array[index] = value;
        return copy;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // переопределяю equals для удобства тестирования
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        MyList objList = (MyList) obj;
        if (size != objList.size()) return false;
        for (int i = 0; i < size; i++)
            if (!array[i].equals(objList.get(i))) return false;
        return true;
    }

}