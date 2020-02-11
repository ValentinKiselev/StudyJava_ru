package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public class Provider {
    public List<Vacancy> getJavaVacancies(String searchString) {
        return null;
    }

    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public Provider() {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
