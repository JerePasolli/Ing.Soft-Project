package main;

import constants.Constants;
import graphics.Assets;
import input.KeyBoard;
import input.Mouse;
import states.GameState;
import states.MenuState;
import states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Window extends JFrame implements Runnable{
    private Thread thread;
    private boolean running = false;
    private final Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;
    private final KeyBoard keyBoard;
    private Mouse mouseInput;
    private double delta = 0; //almacena temporalmente el tpo que va pasando
    private double AVGFPS = Constants.FPS; //saber a cuanto corre el juego en un momento
    private int lives = 3;
    private int score = 0;

    /**
     * Constructor de la clase. Setea los parámetros para la ventana (JFrame) y el canvas donde se va a dibujar.
     * Además setea los "listeners" para mouse y teclado.
     */
    public Window(){
        setTitle("PACMAN");
        setSize(Constants.FRAME_WIDTH+17,Constants.FRAME_HEIGHT+17);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new KeyBoard();
        mouseInput = new Mouse();

        canvas.setPreferredSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        canvas.setMaximumSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        canvas.setMinimumSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        canvas.setFocusable(true);
        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
    }

    /**
     *  Se crea la ventana y se da inicio al juego.
     */
    public static void main(String[] args){
        new Window().start();
    }

    /**
     *  Este metodo se encarga de actualizar constantemente la pantalla en la que se encuentre el usuario (State).
     *  Además actualiza la entrada por teclado.
     */
    private void update(){
        keyBoard.update();
        State.getCurrentState().update();
    }

    /**
     *  Se dibuja y muestra el canvas. Segun el estado en el que se encuentre el juego será lo que se dibujará.
     */
    private void draw(){
        bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //-----------------------------------

        //Graphics2D g2d = (Graphics2D) g;
        //drawMaze(g2d);
        // llamar a drawMaze(), ya que aca se dibuja
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.CANVAS_WIDTH+10, Constants.CANVAS_HEIGHT+10);
        //g.setColor(Color.WHITE);
        //g.drawString(""+AVGFPS, 10, 20);
        //g.drawImage(Assets.up, 100, 100, null);

        State.getCurrentState().draw(g);

        //g.drawString("holaque tal",45,45);
        //g.clearRect(0, 0, WIDTH, HEIGHT);
        //g.drawRect(x,0,100,100);
        //-----------------------------------
        //zona de dibujo arriba
        g.dispose();
        bs.show();
    }

    /**
     *  Carga los recursos del juego, tales como imágenes, fuentes y sonidos. Además da inicio al juego
     *  creando el estado inicial, es decir "MenuState".
     */
    private void init(){
        Assets.init(); //se cargan todos los recursos
        State.changeState(new MenuState());
    }


    /**
     *  En este método run se lleva el conteo del tiempo para garantizar 60 frames por segundo, y se invoca
     *  60 veces por segundo los métodos update y draw (que actualizarán y dibujarán lo qque corresponda según)
     *  el estado.
     */
    @Override
    public void run(){

        long now = 0;
        long lastTime = System.nanoTime(); //tpo actual del sistema
        int frames = 0;
        long time = 0;

        init();

        while(running){
          now = System.nanoTime();
          delta += (now - lastTime)/Constants.TARGETTIME;//tpo que paso hasta este momento sobre TARGETTIME
          time += (now - lastTime);
          lastTime = now;

          if(delta >= 1){
              update();
              draw();
              delta --;
              frames ++;
          }

          if(time >= 1000000000){
            AVGFPS = frames;
            frames = 0;
            time = 0;
          }

        }
        stop();
    }

    /**
     *  Se crea un nuevo hilo para encargarse de la lógica del juego, se crea el hilo, se lanza, y se pone la bandera
     *  de "running" en "true".
     */
    private void start(){
        thread = new Thread(this);
        thread.start(); // lanza el run()
        running = true;
    }

    /**
     *  Detiene la ejecución del juego
     */
    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Canvas getCanvas() {
        return canvas;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public Mouse getMouseInput() {
        return mouseInput;
    }
}
