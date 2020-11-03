package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<String, Double> statMap = StatisticManager.getInstance().getAdvertisementProfit();
        Double total = 0D;
        for (Map.Entry<String, Double> entry : statMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }
        if (total > 0) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
        }
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> statMap = StatisticManager.getInstance().getCookWorkloading();
        for (Map.Entry<String, Map<String, Integer>> entryMap : statMap.entrySet()) {
            for (Map.Entry<String, Integer> entry : entryMap.getValue().entrySet()) {
                //Выводим дату
                ConsoleHelper.writeMessage(entryMap.getKey());
                //Выводим повара
                String cookName = entry.getKey();
                int workTime = (int) Math.ceil(entry.getValue() / 60.0);
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
            }
        }
    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {
    }
}
