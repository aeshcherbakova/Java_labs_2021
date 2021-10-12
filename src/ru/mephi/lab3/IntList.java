package ru.mephi.lab3;
import ru.mephi.lab1.MyList;

import java.lang.Exception.*;

// реализация динамического массива целых чисел + функция слияния списков
public class IntList {

    private int[] array;
    private int size = 0;
    private static final double resizeFactor = 1.2;


    // пустой конструктор
    public IntList() {
        array = new int[10];
    }

    // пустой конструктор с заданным размером
    public IntList(int size) {
        if(size <= 0) throw new IllegalArgumentException("size of the list must be positive");
        array = new int[(int) (size * resizeFactor)];
    }

    // копирующий конструктор
    public IntList(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("Array as the argument must not be null");
        else {
            size = arr.length;
            this.array = new int[(int) (size * resizeFactor)];
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
        int[] newArr = new int[newSize];
        System.arraycopy(array, 0, newArr, 0, size);
        this.array = newArr;
    }

    public void add(int value) {
        checkResize();
        array[size++] = value;
    }

    // вставляет элемент на данную позицию
    public void add(int value, int index) {
        isIndexInRange(index);
        checkResize();
        if (index < 0) index = 0;
        else if (index > size) index = size;
        for (int i = size++; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
    }

    public int remove(int index) {
        isIndexInRange(index);
        int copy = array[index];
        size--;
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        return copy;
    }

    public int get(int index) {
        isIndexInRange(index);
        return array[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++)
            if (array[i] == value) return i;
        return -1;
    }

    public boolean contains(int value) {
        for (int o : array)
            if (o == value) return true;
        return false;
    }

    // вставляет элемент вместо другого и возвращает старый элемент, который был по этому индексу
    public int set(int value, int index) {
        isIndexInRange(index);
        int copy = array[index];
        array[index] = value;
        return copy;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void isIndexInRange(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index must be positive");
        if (index >= size) throw new IndexOutOfBoundsException("Index must be less then list size");
    }

    public IntList merge(IntList other) {
        if(other == null || other.size() == 0) return this;
        int sumSize = this.size + other.size();
        IntList newList = new IntList(sumSize);
        int i = 0, j = 0;
        do {
            int nextThis = this.array[i];
            int nextOther = other.get(i);
            if(nextThis < nextOther) {
                newList.add(nextThis);
                i++;
            }
            else {
                newList.add(nextOther);
                j++;
            }
        } while(i < size && j < other.size());

        for(; i < size; i++) newList.add(array[i]);
        for(; j < size; j++) newList.add(other.get(i));
        return newList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        IntList objList = (IntList) obj;
        if (size != objList.size()) return false;
        for (int i = 0; i < size; i++)
            if(array[i] != objList.get(i)) return false;
        return true;
    }

}