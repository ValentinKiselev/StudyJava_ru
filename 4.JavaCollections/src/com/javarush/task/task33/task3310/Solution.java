package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        testStrategy(strategy1, 1000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> idforstring = new HashSet<>();
        for (String string : strings) {
            idforstring.add(shortener.getId(string));
        }
        return idforstring;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long id : keys) {
            strings.add(shortener.getString(id));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> teststrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            teststrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Set<Long> SetIds;
        Date start1 = new Date();
        SetIds = getIds(shortener, teststrings);
        Date finish1 = new Date();
        long delaygetIds = finish1.getTime() - start1.getTime();
        Helper.printMessage(Long.toString(delaygetIds));

        Set<String> Setstring;
        Date start2 = new Date();
        Setstring = getStrings(shortener, SetIds);
        Date finish2 = new Date();
        long delaygetIds2 = finish2.getTime() - start2.getTime();
        Helper.printMessage(Long.toString(delaygetIds2));

        if (teststrings.equals(Setstring)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }
}