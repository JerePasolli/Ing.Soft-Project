package main;

import constants.Constants;
import graphics.Assets;
import input.KeyBoard;
import states.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Window extends JFrame implements Runnable{
    private Thread thread;
    private boolean running = false;
    private final Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;
    private GameState gameState;
    private final KeyBoard keyBoard;
    private double delta = 0; //almacena temporalmente el tpo que va pasando
    private double AVGFPS = Constants.FPS; //saber a cuanto corre el juego en un momento

    private final short[] levelData = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };
    private short[] screenData;

    public Window(){
        setTitle("PACMAN");
        setSize(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        keyBoard = new KeyBoard();

        canvas.setPreferredSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        canvas.setMaximumSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        canvas.setMinimumSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
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
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        g.setColor(Color.WHITE);
        //g.drawString(""+AVGFPS, 10, 20);
        //g.drawImage(Assets.up, 100, 100, null);

        gameState.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        drawMaze(g2d);
        //g.drawString("holaque tal",45,45);
        //g.clearRect(0, 0, WIDTH, HEIGHT);
        //g.drawRect(x,0,100,100);
        //-----------------------------------
        //zona de dibujo arriba
        g.dispose();
        bs.show();
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;
        screenData = new short[Constants.N_BLOCKS * Constants.N_BLOCKS];
        for (int c = 0; c < Constants.N_BLOCKS * Constants.N_BLOCKS; c++) {
            screenData[c] = levelData[c];
        }

        for (y = 0; y < Constants.SCREEN_SIZE; y += Constants.BLOCK_SIZE) {
            for (x = 0; x < Constants.SCREEN_SIZE; x += Constants.BLOCK_SIZE) {

                g2d.setColor(new Color(0,72,251));
                g2d.setStroke(new BasicStroke(5));

                if ((levelData[i] == 0)) {
                    g2d.fillRect(x, y, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
                }

                if ((screenData[i] & 1) != 0) {
                    g2d.drawLine(x, y, x, y + Constants.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) {
                    g2d.drawLine(x, y, x + Constants.BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) {
                    g2d.drawLine(x + Constants.BLOCK_SIZE - 1, y, x + Constants.BLOCK_SIZE - 1,
                            y + Constants.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) {
                    g2d.drawLine(x, y + Constants.BLOCK_SIZE - 1, x + Constants.BLOCK_SIZE - 1,
                            y + Constants.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) {
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }

                i++;
            }
        }

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
