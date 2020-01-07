package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry<key, value> implements Serializable {
    final Long key;
    String value;
    Entry<key, value> next;
    final int hash;

    public Entry(int hash, Long key, String value, Entry<key, value> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) + Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) &&
                Objects.equals(value, entry.value);

    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public Long getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

}
