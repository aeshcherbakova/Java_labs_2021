package ru.mephi.lab1;

// реализация динамического массива
public class MyList {

    private Object[] array;
    private int size = 0;  // actual size of the list; capacity (allocated size) = array.length
    private static final double resizeFactor = 1.2;


    // пустой конструктор
    public MyList() {
        this.array = new Object[10];
    }

    // пустой конструктор с заданным размером
    public MyList(int size) {
        if(size < 0) {
            size = 10;
        }
        this.array = new Object[size];
    }

    // копирующий конструктор
    public MyList(Object[] arr) {
        if (arr == null) {
            this.array = new Object[10];
        }
        else {
            this.size = arr.length;
            this.array = new Object[(int) (this.size * resizeFactor)];
            System.arraycopy(arr, 0, this.array, 0, this.size);
        }
    }

    private void checkResize() {
        if (this.size == this.array.length) {
            resize();
        }
    }

    // увеличение размера массива, если весь занят
    private void resize() {
        int newSize = (this.size < 5) ? 5 : (int) (this.array.length * resizeFactor);
        Object[] newArr = new Object[newSize];
        System.arraycopy(this.array, 0, newArr, 0, this.size);
        this.array = newArr;
    }

    public void add(Object value) {
        if (value == null) {
            return;
        }
        checkResize();
        this.array[this.size++] = value;
    }

    // вставляет элемент на данную позицию
    public void add(Object value, int index) {
        if (value != null) {
            checkResize();
            if (index < 0) {
                index = 0;
            }
            else if (index > this.size) {
                index = this.size;
            }
            for (int i = this.size++; i > index; i--)
                this.array[i] = this.array[i - 1];
            this.array[index] = value;
        }
    }

    public Object remove(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        Object copy = this.array[index];
        this.size--;
        for(int i = index; i < this.size; i++) {
            this.array[i] = this.array[i + 1];
        }
        return copy;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        return this.array[index];
    }

    // возвращает -1, если элемент не найден
    public int indexOf(Object value) {
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        if (value == null) {
            return false;
        }
        for (Object o : this.array) {
            if (o == value) {
                return true;
            }
        }
        return false;
    }

    // вставляет элемент вместо другого и возвращает старый элемент, который был по этому индексу
    public Object set(Object value, int index) {
        if (index < 0 || index >= this.size || value == null) {
            return null;
        }
        Object copy = this.array[index];
        this.array[index] = value;
        return copy;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // переопределяю equals для удобства тестирования
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MyList objList = (MyList) obj;
        if (this.size != objList.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.array[i].equals(objList.get(i))) {
                return false;
            }
        }
        return true;
    }

}