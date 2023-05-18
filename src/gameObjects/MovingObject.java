package gameObjects;

import math.Vector2D;

import java.awt.*;

public abstract class MovingObject extends GameObject{

    protected Vector2D velocity;
    protected double angle;
    public MovingObject(Vector2D position, Vector2D velocity, Image texture) {
        super(position, texture);
        this.velocity = velocity;
        this.angle = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }
}
