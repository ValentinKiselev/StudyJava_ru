package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT =  "http://hh.ru/search/vacancy?text=java+%s&page=%d";
                         String url = String.format(URL_FORMAT, "Kiev", 3);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        org.jsoup.nodes.Document doc = null;
        try {
            doc = Jsoup.connect(URL_FORMAT).get();
            String buff = doc.html();

            RandomAccessFile raf = new RandomAccessFile("./content.html", "rw");
            raf.write(buff.getBytes());
            raf.close();
            System.out.println(doc.html());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
