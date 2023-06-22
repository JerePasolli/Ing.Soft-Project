package gameObjects;

import constants.Constants;
import graphics.Assets;
import graphics.Sound;
import math.Vector2D;
import states.GameState;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghost {
    private final int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    private final int[] validSpeeds = {1, 1, 2, 2};
    private final int[] dx, dy;
    private final GameState gameState;
    private final Image texture;
    private boolean finished;

    public Ghost(Image texture,GameState gameState) {
        int x = 1;
        finished=false;
        this.texture = texture;
        this.gameState = gameState;
        ghost_x = new int[Constants.N_GHOSTS];
        ghost_dx = new int[Constants.N_GHOSTS];
        ghost_y = new int[Constants.N_GHOSTS];
        ghost_dy = new int[Constants.N_GHOSTS];
        ghostSpeed = new int[Constants.N_GHOSTS];
        dx = new int[4];
        dy = new int[4];

        for (int i = 0; i < Constants.N_GHOSTS; i++) {
            ghost_y[i] = 7 * Constants.BLOCK_SIZE; //start position
            ghost_x[i] = 7 * Constants.BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = x;
            x = -x;
        }

    }
    
    public void move(){

    }


    public void update() {

        int pos;
        int count;

        for (int i = 0; i < Constants.N_GHOSTS; i++) {
            ghostSpeed[i] = validSpeeds[i];
            if (ghost_x[i] % Constants.BLOCK_SIZE == 0 && ghost_y[i] % Constants.BLOCK_SIZE == 0) {
                pos = ghost_x[i] / Constants.BLOCK_SIZE + Constants.N_BLOCKS * (ghost_y[i] / Constants.BLOCK_SIZE);

                count = 0;

                if ((gameState.getScreenData()[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((gameState.getScreenData()[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((gameState.getScreenData()[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((gameState.getScreenData()[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((gameState.getScreenData()[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);

            if(gameState.getPacman().getX()>(ghost_x[i]-12) && gameState.getPacman().getX()<(ghost_x[i]+12)
                && gameState.getPacman().getY()>(ghost_y[i]-12) && gameState.getPacman().getY()<(ghost_y[i]+12)){
                    finished=true;  
                }

        }

    }


    public void draw(Graphics g) {
        for(int i = 0; i < Constants.N_GHOSTS; i++){
            g.drawImage(texture, ghost_x[i] + 1, ghost_y[i] + 1, null);
        }

    }
    public boolean getFinished(){
        return finished;
    }


}
