package states;

import constants.Constants;
import gameObjects.Ghost;
import gameObjects.Pacman;
import graphics.Assets;
import graphics.Sound;

import java.awt.*;
import java.util.ArrayList;

import input.KeyBoard;
import io.ScoreData;
import observer.Observer;

public class GameState extends State{

    private Pacman pacman;
    private Ghost ghosts;
    private ScoreData scoreData;
    private ArrayList<Observer> observers;
    private short[] screenData;
    private Sound music,mdeadth;
    private int score = 0;
    private int lives = 3;
    private boolean powerUp;
    /*private final short[] levelData2 = {
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
    };*/
    private final short[] levelData = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 35, 26, 26, 18, 26, 22, 0, 19, 26, 18, 26, 26, 38, 0,
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
            0, 41, 26, 26, 24, 26, 26, 26, 26, 26, 24, 26, 26, 44, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    /**
     *  Constructor de la clase. inicia el juego propiamente dicho, se llama al pulsar el boton de play.
     */
    public GameState(){
        initGame();
    }

    /**
     *  Inicia el juego, aplicando los efectos de sonido al Pacman, y seteando en cero el score. Se inicializan los
     *  fantasmas y el Pacman.
     */
    private void initGame(){
        music=new Sound(Assets.ghostm);
        music.loopClip();
        score=0;
        this.scoreData = new ScoreData();
        pacman = new Pacman(7*Constants.BLOCK_SIZE,10*Constants.BLOCK_SIZE,Assets.right,this);
      
        ghosts = new Ghost(this, pacman);
        observers = new ArrayList<Observer>();
        screenData = new short[Constants.N_BLOCKS * Constants.N_BLOCKS];
        for (int c = 0; c < Constants.N_BLOCKS * Constants.N_BLOCKS; c++) {
            screenData[c] = levelData[c];
        }
    }

    /**
     *  Permite registrar a un observador en el ArrayList de observers.
     *  @param obs observador a registrar
     */
    public void register(Observer obs){
        observers.add(obs);
    }

    /**
     *  Revive al Pacman al perder una vida, y resetea a los fantasmas a su posicion inicial.
     */
    private void reanimatePacman(){
        music= new Sound(Assets.ghostm);
        music.loopClip();
        pacman = new Pacman(7*Constants.BLOCK_SIZE,10*Constants.BLOCK_SIZE,Assets.right,this);
        ghosts = new Ghost(this, pacman);
   }

    /**
     *  Actualiza estado de fantasmas y Pacman.
     */
    public void update() {
        int i=0;
        boolean finished=true;
        if(ghosts.getFinished()){
            lives--;
            mdeadth=new Sound(Assets.death);
            music.stop();
            mdeadth.play();
            observers.get(0).update(false);
            reanimatePacman();
        }
        while(i<Constants.N_BLOCKS*Constants.N_BLOCKS && finished){
            if((screenData[i] & 48)!=0){
                finished=false;
            }
            i++;
        }
        if(finished || lives==0){
            addScore(lives*10);
            music.stop();
            //State.changeState(new NewBestState(this.scoreData));
            observers.get(0).update(true);
        }
        else{
            if(KeyBoard.ESCAPE){
                changeState(new PauseState(this));
            }
            pacman.update();
            ghosts.update();
        }
    }
    //---------------------------DRAW-----------------------------------
    /**
     *  Dibuja al Pacman, los fantasmas, el escenario y el hud de puntaje y vida.
     *  @param g graficos para dibujar
     */
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        pacman.draw(g);
        ghosts.draw(g);
        drawMaze((Graphics2D) g);
        drawScoreAndLives(g);
    }

    /**
     *  Dibuja el hud de score y vidas.
     *  @param g graficos para dibujar
     */
    private void drawScoreAndLives(Graphics g) {
        g.setFont(Constants.smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "score: " + score;
        g.drawString(s, Constants.SCREEN_SIZE / 2 + 96, Constants.SCREEN_SIZE + 16);

        for (int i = 0; i < lives; i++) {
            g.drawImage(Assets.heart, i * 28 + 8, Constants.SCREEN_SIZE + 1, null);
        }
    }

    /**
     *  Dibuja escenario o laberinto.
     *  @param g2d graficos para dibujar
     */
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
                if ((screenData[i] & 32) != 0) {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillOval(x + 10, y + 10, 12, 12);
                }

                i++;
            }
        }

    }
    //----------CONTROL DE VIDA Y PUNTAJE-------------
    /**
     *  Suma el score que recibe al score global.
     *  @param x score a sumar
     */
    public void addScore(int x){
        score += x;
        scoreData.setScore(score);
    }

    /**
     *  Resta una vida al jugador.
     */
    public void susbtractLife(){
        lives --;
    }

    //--------------GETTERS Y SETTERS-------------------

    /**
     *  Retorna los datos en pantalla del escenario.
     *  @return datos en pantalla del escenario
     */
    public short[] getScreenData(){
        return this.screenData;
    }

    /**
     *  Permite modificar los datos en pantalla del escenario.
     *  @param pos posicion en pantalla a modificar
     *  @param value valor a colocar en esa posicion
     */
    public void setScreenData(int pos,short value){
        this.screenData[pos]=value;
    }

    /**
     *  Retorna la cantidad de vidas restantes del jugador.
     *  @return cantidad de vidas restantes
     */
    public int getLives(){
        return lives;
    }

    /**
     *  Retorna la instancia de Pacman que se esta utilizando en este estado.
     *  @return instancia del Pacman
     */
    public Pacman getPacman() {
        return pacman;
    }

    /**
     *  Retorna el score actual del jugador.
     *  @return score del jugador
     */
    public ScoreData getScoreData(){
        return scoreData;
    }

    /**
     *  Retorna la cantidad de vidas restantes del jugador.
     *  @return cantidad de vidas restantes
     */
    public void setPowerUp(boolean powerUp){
        this.powerUp=powerUp;
    }

    /**
     *  Retorna el valor de powerUp (estado de los fantasmas).
     *  @return valor de powerUp
     */
    public boolean getPowerUp(){
        return powerUp;
    }
}
