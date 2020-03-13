package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

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
}
