package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.Controller;

import javax.swing.*;
import com.javarush.task.task34.task3410.controller.EventListener;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public void setEventListener(EventListener eventListener){ this.field.setEventListener(eventListener);}

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
}
