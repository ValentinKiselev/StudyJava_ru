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
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {

        return null == map.put(e,PRESENT);
    }

    @Override
    public int size() {
        return map.size();
    }
    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object clone() {
        Set<E> set = new AmigoSet<>();
        try {
            HashMap<E, Object> mapHelp = (HashMap<E, Object>) this.map.clone();
            for (Map.Entry<E, Object> it : mapHelp.entrySet()) {
                set.add(it.getKey());
            }
        } catch (Exception e) {
            throw new InternalError();
        }
        return set;
    }
}
