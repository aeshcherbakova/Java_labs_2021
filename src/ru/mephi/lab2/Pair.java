package ru.mephi.lab2;

public class Pair {
    Object key;
    Object value;

    Pair(Object _key, Object _value) {
        this.key = _key;
        this.value = _value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Pair objPair = (Pair) obj;
        return key.equals(objPair.key) && value.equals(objPair.value);
    }
}