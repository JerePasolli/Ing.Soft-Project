package math;

public class Vector2D {

    private int x, y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D add(Vector2D v){
        return new Vector2D(x + v.getX(), y + v.getY());
    }
    public double getMagnitude()
    {
        return Math.sqrt(x*x + y*y);
    }
    public Vector2D substract(Vector2D v){
        return new Vector2D(x - v.getX(), y - v.getY());
    }

    public Vector2D addX(Vector2D v){
        return new Vector2D(x + v.getX(), y);
    }

    public Vector2D addY(Vector2D v){
        return new Vector2D(x, y + v.getY());
    }

    public Vector2D substractX(Vector2D v){
        return new Vector2D(x - v.getY(), y);
    }

    public Vector2D substractY(Vector2D v){
        return new Vector2D(x, y - v.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
