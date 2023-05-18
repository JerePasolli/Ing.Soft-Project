package gameObjects;

import math.Vector2D;

import java.awt.*;

public abstract class GameObject {

    protected Image texture;
    protected Vector2D position;

    public GameObject(Vector2D position, Image texture){
        this.position = position;
        this.texture = texture;
    }

    public abstract void update();
    public abstract void draw(Graphics g);

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
