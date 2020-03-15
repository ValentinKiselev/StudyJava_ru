package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CurrencyManipulator() {

    }
    public boolean hasMoney(){
        return denominations.size()!=0;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount(){
        int result = 0;

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            result = result + (pair.getKey() * pair.getValue());
        }
        return result;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        if (!hasMoney()) throw new NotEnoughMoneyException();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> keys = new TreeSet<>(Comparator.reverseOrder());
        keys.addAll(denominations.keySet());
        Map<Integer, Integer> copyDenoninations = new TreeMap<>(Comparator.reverseOrder());
        copyDenoninations.putAll(denominations);

        int intPart, modPart = expectedAmount, val, save, testsum = 0;

        for (Integer key: keys) {
            intPart = modPart / key;
            modPart = modPart % key;
            if (intPart > 0) {
                val = copyDenoninations.get(key) - intPart >= 0 ? intPart: copyDenoninations.get(key);
                save = copyDenoninations.get(key) - intPart >= 0 ? copyDenoninations.get(key) - intPart: 0;
                if (val < intPart) modPart += (intPart - val) * key;
                if (save == 0) copyDenoninations.remove(key);
                else copyDenoninations.put(key, save);
                map.put(key, val);
                testsum += (val * key);
            }
            if (modPart == 0) break;
        }
        if (testsum != expectedAmount) throw new NotEnoughMoneyException();
        denominations = copyDenoninations;
        return map;
    }
}
