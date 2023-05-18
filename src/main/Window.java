package main;

import constants.Constants;
import graphics.Assets;
import input.KeyBoard;
import states.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static constants.Constants.FPS;
import static constants.Constants.TARGETTIME;

public class Window extends JFrame implements Runnable{
    private Thread thread;
    private boolean running = false;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;
    private GameState gameState;
    private KeyBoard keyBoard;
    private double delta = 0; //almacena temporalmente el tpo que va pasando
    private double AVGFPS = FPS; //saber a cuanto corre el juego en un momento

    public Window(){
        setTitle("PACMAN");
        setSize(Constants.WIDHT, Constants.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        keyBoard = new KeyBoard();

        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);
        add(canvas);
        canvas.addKeyListener(keyBoard);
    }

    public static void main(String[] args){
        new Window().start();
    }

    private void update(){
        keyBoard.update();
        gameState.update();
    }

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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        gameState.draw(g);
        g.drawString(""+AVGFPS, 10, 20);
        //-----------------------------------
        //zona de dibujo arriba
        g.dispose();
        bs.show();
    }

    private void init(){
        Assets.init(); //se cargan todos los recursos
        gameState = new GameState();
    }


    @Override
    public void run(){

        long now = 0;
        long lastTime = System.nanoTime(); //tpo actual del sistema
        int frames = 0;
        long time = 0;

        init();

        while(running){
          now = System.nanoTime();
          delta += (now - lastTime)/TARGETTIME;//tpo que paso hasta este momento sobre TARGETTIME
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

    private void start(){
        thread = new Thread(this);
        thread.start(); // lanza el run()
        running = true;
    }

    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
