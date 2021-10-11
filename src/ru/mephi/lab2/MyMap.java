package ru.mephi.lab2;
import ru.mephi.lab1.MyList;

public class MyMap {

    private final MyTypedList<Pair> table;

    public MyMap() {
        table = new MyTypedList<Pair>();
    }

    public void put(Object key, Object value) {
        if(key == null) return;
        for(Pair pair: table)
            if(pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        table.add(new Pair(key, value));
    }

    public Object get(Object key) {
        for(Pair pair: table)
            if(pair.key.equals(key))
                return pair.value;
        return null;
    }

    public Object get(Object key, Object bydefault) {
        for(Pair pair: table)
            if(pair.key.equals(key))
                return pair.value;
        return bydefault;
    }

    public Object remove(Object key) {
        for(int i = 0; i < table.size(); i++)
            if(table.get(i).key.equals(key)) {
                Object copyValue = table.get(i).value;
                table.remove(i);
                return copyValue;
            }
        return null;
    }

    public boolean keyContains(Object key) {
        for(Pair pair: table)
            if(pair.key.equals(key)) return true;
        return false;
    }

    public MyList getKeys() {
        MyList keys = new MyList(table.size());
        for(Pair pair: table)
            keys.add(pair.key);
        return keys;
    }

    public MyList getValues() {
        MyList values = new MyList(table.size());
        for(Pair pair: table)
            values.add(pair.value);
        return values;
    }

    public MyList getEntries() {
        MyList entries = new MyList(table.size());
        for(Pair pair: table)
            entries.add(pair);
        return entries;
    }

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

}
