package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map = new HashMap<>();

    public AmigoSet() {
        this.map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection){
        int capacity = Math.max(16, (int) Math.floor(collection.size() / .75f) + 1);
        map = new HashMap<>(capacity);

        for (E e : collection) {
            this.add(e);
        }
    }


    @Override
    public boolean add(E e) {

        return null == map.put(e,PRESENT);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
