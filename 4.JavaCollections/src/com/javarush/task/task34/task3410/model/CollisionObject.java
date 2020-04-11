package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        if (gameObject==null || direction==null) return false;

        int x = this.getX();
        int y = this.getY();

        if (direction.equals(Direction.UP)) y = y - Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.DOWN)) y = y + Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.LEFT)) x = x - Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.RIGHT)) x = x + Model.FIELD_CELL_SIZE;

        if (x==gameObject.getX() && y==gameObject.getY()) return true;

        return false;
    }
}
