package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    public static StatisticManager getInstance(){
        return instance == null ? new StatisticManager() : instance;
    }
    private StatisticManager() {
    }
    public void register(EventDataRow data){

    }
}
