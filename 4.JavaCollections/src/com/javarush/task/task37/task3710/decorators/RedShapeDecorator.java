package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    private Shape decoratedShape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    private void setBorderColor(Shape shape){
        System.out.print("Setting the border color for ");
        System.out.print(shape.getClass().getSimpleName());
        System.out.print(" to red.");
        System.out.println("");
    }
    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        super.draw();
    }
}
