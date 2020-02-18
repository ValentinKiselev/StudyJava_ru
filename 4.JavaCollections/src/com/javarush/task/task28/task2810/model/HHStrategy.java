package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT =  "http://hh.ru/search/vacancy?text=java+%s&page=%d";
                         String url = String.format(URL_FORMAT, "Kiev", 3);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        org.jsoup.nodes.Document doc = null;
        try {
            doc = Jsoup.connect(URL_FORMAT).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36").referrer("no-referrer-when-downgrade").get();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
