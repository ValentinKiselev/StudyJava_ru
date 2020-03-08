package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){

        currencyCode = currencyCode.toUpperCase();

        CurrencyManipulator currencyManipulator = map.get(currencyCode);
        if (currencyManipulator == null) {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
            return map.get(currencyCode);
        }
        return currencyManipulator;
    }

    private CurrencyManipulatorFactory() {

    }
}
