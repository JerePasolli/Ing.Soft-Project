package math;

public class Vector2D {

    private int x, y;

    /**
     *  Constructor de la clase
     *  @param x coordenada "x" del vector
     * @param y coordenada "y" del vector
     */
    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     *  Constructor de la clase sin parámetros, inicializa las coordenadas en (0;0).
     */
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    /**
     *  Retorna la coordenada "x" del vector
     *  @return coordenada "x" del vector
     */
    public int getX() {
        return x;
    }

    /**
     *  Permite modificar la coordenada "x" de un vector
     *  @param x coordenada "x" del vector
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *  Retorna la coordenada "y" del vector
     *  @return coordenada "y" del vector
     */
    public int getY() {
        return y;
    }

    /**
     *  Permite modificar la coordenada "y" de un vector
     *  @param y coordenada "y" del vector
     */
    public void setY(int y) {
        this.y = y;
    }
}
