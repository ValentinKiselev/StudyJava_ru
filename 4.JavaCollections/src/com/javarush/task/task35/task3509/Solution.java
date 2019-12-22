package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T>ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> r = new ArrayList<>();
        for(T e: elements){
            r.add(e);
        }
        return r;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {

        HashSet<T> r = new HashSet<>();
        for (T e : elements)
            r.add(e);

        return r;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {

        if (keys.size() != values.size())
            throw new IllegalArgumentException();

        HashMap<K, V> r = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            r.put(keys.get(i), values.get(i));
        }

        return r;
    }

}
