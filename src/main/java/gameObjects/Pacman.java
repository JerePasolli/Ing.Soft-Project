package gameObjects;

import graphics.Assets;
import graphics.Sound;
import input.KeyBoard;
import constants.Constants;
import states.GameState;


import java.awt.*;

public class Pacman extends GameObject{
    private int req_dx,req_dy;
    private Sound music1,music2;
    private boolean bn;
    public Pacman(int pacman_x,int pacman_y,Image texture,GameState gameState){
        super(pacman_x,pacman_y,texture,gameState);
        this.dx=0;
        this.dy=0;
        music1 = new Sound(Assets.eatMusic1);
        music2 = new Sound(Assets.eatMusic2);
        
    }

    public void update(){
        if(KeyBoard.LEFT){
            texture=Assets.left;
            req_dx=-1;
            req_dy=0;
        }
        if(KeyBoard.RIGHT){
            texture=Assets.right;
            req_dx=1;
            req_dy=0;
        }
        if(KeyBoard.UP){
            texture=Assets.up;
            req_dx=0;
            req_dy=-1;
        }
        if(KeyBoard.DOWN){
            texture=Assets.down;
            req_dx=0;
            req_dy=1;
        }
        movePacman();
    }
    public void movePacman(){
        int pos;
        short ch;

        if (this.x % Constants.BLOCK_SIZE == 0 && this.y % Constants.BLOCK_SIZE == 0) {
            pos = this.x / Constants.BLOCK_SIZE + Constants.N_BLOCKS * (int) (this.y / Constants.BLOCK_SIZE);
            ch = gameState.getScreenData()[pos];

            if ((ch & 16) != 0) {
                gameState.setScreenData(pos,(short)(ch & 15));
                gameState.addScore(1);
                if(!bn){
                    music1.play();
                    bn=!bn;
                }
                else{
                    music2.play();
                    bn=!bn;
                }
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    dx = req_dx;
                    dy= req_dy;
                }
            }

            // Check for standstill
            if ((dx == -1 && dy== 0 && (ch & 1) != 0)
                    || (dx == 1 && dy == 0 && (ch & 4) != 0)
                    || (dx == 0 && dy == -1 && (ch & 2) != 0)
                    || (dx == 0 && dy == 1 && (ch & 8) != 0)) {
                dx = 0;
                dy = 0;
            }
        } 
        this.x = this.x + Constants.PACMAN_SPEED * dx;
        this.y = this.y + Constants.PACMAN_SPEED * dy;
    }
    public void draw(Graphics g){
        g.drawImage(texture,x+1,y+1,null);
    }

}
