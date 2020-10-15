package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager instance = new StatisticManager();

    public static StatisticManager getInstance() {
        return instance == null ? new StatisticManager() : instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>>  storage = new HashMap<>();
        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

    }

}
