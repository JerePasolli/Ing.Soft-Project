package gameObjects;

import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;
import constants.Constants;
import states.GameState;

import javax.swing.*;
import java.awt.*;

public class Pacman {
    private int pacman_x,pacman_y,pacmand_x,pacmand_y;
    private int req_dx,req_dy;
    private GameState gameState;
    private Image texture;

    public Pacman(int pacman_x,int pacman_y,Image texture,GameState gameState){
        this.pacman_x=pacman_x;
        this.pacman_y=pacman_y;
        this.texture=texture;
        this.gameState=gameState;
        this.pacmand_x=0;
        this.pacmand_y=0;
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

        if (pacman_x % Constants.BLOCK_SIZE == 0 && pacman_y % Constants.BLOCK_SIZE == 0) {
            pos = pacman_x / Constants.BLOCK_SIZE + Constants.N_BLOCKS * (int) (pacman_y / Constants.BLOCK_SIZE);
            ch = gameState.getScreenData()[pos];

            if ((ch & 16) != 0) {
                gameState.setScreenData(pos,(short)(ch & 15));
                gameState.addScore(1);
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        } 
        pacman_x = pacman_x + Constants.PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + Constants.PACMAN_SPEED * pacmand_y;
    }
    public void drawPacman(Graphics g){
        g.drawImage(texture,pacman_x+1,pacman_y+1,null);
    }

}
