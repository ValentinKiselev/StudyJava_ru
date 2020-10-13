package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage =  AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos() {
        List<Advertisement> availableVideos = storage.list();
        List<Advertisement> videoToBeShown = new ArrayList<>();
        if (availableVideos.isEmpty()) throw new NoVideoAvailableException();

    }
}
