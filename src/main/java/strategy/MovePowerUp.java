package strategy;

import constants.Constants;
import graphics.Assets;

import java.awt.*;

public class MovePowerUp implements MovementStrategy{
    private int[] ghost_x, ghost_y;

    public MovePowerUp(int[] gx, int[] gy){
        ghost_x = gx;
        ghost_y = gy;
    }

    public void changeColor(Graphics g){
        for(int i = 0; i < Constants.N_GHOSTS; i++){
            g.drawImage(Assets.blueGhost, ghost_x[i] + 1, ghost_y[i] + 1, null);
        }
    }
}
