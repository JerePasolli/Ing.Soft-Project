package states;

import constants.Constants;
import gameObjects.Ghost;
import gameObjects.MovingObject;
import gameObjects.Pacman;
import graphics.Assets;
import graphics.Sound;
import math.Vector2D;
import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{

    private Pacman pacman;
    private final ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
    private int ghostNumber;
    private short[] screenData;
    private int score = 0;
    private int lives = 3;
    private final short[] levelData2 = {
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
    private final short[] levelData = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 19, 26, 26, 18, 26, 22, 0, 19, 26, 18, 26, 26, 22, 0,
            0, 21, 0, 0, 21, 0, 21, 0, 21, 0, 21, 0, 0, 21, 0,
            0, 17,  26,  26,  16,  26, 24, 26, 24, 26, 16, 26, 26, 20, 0,
            0, 21, 0, 0, 21, 0, 0, 0, 0, 0, 21, 0, 0, 21, 0,
            0, 25, 26, 26, 16, 10, 10, 2, 10, 10, 16,  26,  26,   28, 0,
            0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 5,  0,  0,   0, 0,
            0, 11, 10, 10, 4, 0, 3, 16, 6, 0, 1,  10,  10,   14, 0,
            0, 0, 0, 0, 5, 0, 9, 8, 12, 0, 5, 0, 0, 0, 0,
            0, 19, 26, 26, 4, 0, 0, 0, 0, 0, 1, 26, 26, 22, 0,
            0, 21,  0,  0,  1,  10,  10,   10, 10, 10, 4, 0, 0, 21, 0,
            0, 17, 26, 26, 20, 0, 0, 0, 0, 0, 17,26,26, 20, 0,
            0, 21, 0, 0, 21, 0, 0, 0, 0, 0, 21, 0, 0, 21, 0,
            0, 25, 26, 26, 24, 26, 30, 0, 27, 26, 24, 26, 26, 28, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private Sound music;

    public GameState(){
        pacman = new Pacman(7*Constants.BLOCK_SIZE,10*Constants.BLOCK_SIZE,Assets.right,this);
        //movingObjects.add(pacman);
        ghostNumber = 4;
        startGhostsWave();
        //music = new Sound(Assets.backgroundMusic);
        //music.loopClip();
        screenData = new short[Constants.N_BLOCKS * Constants.N_BLOCKS];
        for (int c = 0; c < Constants.N_BLOCKS * Constants.N_BLOCKS; c++) {
            screenData[c] = levelData[c];
        }
    }

    public void startGhostsWave(){
        int x, y;

        for(int i = 0; i < ghostNumber; i++){
            x = 20;
            y = 65;

            Image texture = Assets.ghost;
            movingObjects.add(new Ghost(new Vector2D(x, y), new Vector2D(Constants.GHOST_SPEED, Constants.GHOST_SPEED), texture, this, this.screenData));
        }
    }

    public void update(){
        for (MovingObject movingObject : movingObjects) {
            try{
                movingObject.update();
            }
            catch(AWTException e){
                e.printStackTrace();
            }

        }
        pacman.update();
    }
    //---------------------------DRAW-----------------------------------
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (MovingObject movingObject : movingObjects) {
            movingObject.draw(g);
        }
        pacman.drawPacman(g);
        drawMaze((Graphics2D) g);
        drawScoreAndLives(g);
    }

    private void drawScoreAndLives(Graphics g) {
        g.setFont(Constants.smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + score;
        g.drawString(s, Constants.SCREEN_SIZE / 2 + 96, Constants.SCREEN_SIZE + 16);

        for (int i = 0; i < lives; i++) {
            g.drawImage(Assets.heart, i * 28 + 8, Constants.SCREEN_SIZE + 1, null);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;
        for (y = 0; y < Constants.SCREEN_SIZE; y += Constants.BLOCK_SIZE) {
            for (x = 0; x < Constants.SCREEN_SIZE; x += Constants.BLOCK_SIZE) {

                g2d.setColor(Color.BLUE);
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
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }

                i++;
            }
        }

    }
    //----------CONTROL DE VIDA Y PUNTAJE-------------
    public void addScore(int x){
        score += x;
    }

    public void susbtractLife(){
        lives --;
    }

    //--------------GETTERS Y SETTERS-------------------

    public short[] getScreenData(){
        return this.screenData;
    }

    public void setScreenData(int pos,short value){
        this.screenData[pos]=value;
    }

    public int getLives(){
        return lives;
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public Pacman getPacman() {
        return pacman;
    }
}
