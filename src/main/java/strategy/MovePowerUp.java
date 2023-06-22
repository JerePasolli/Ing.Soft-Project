package strategy;

import constants.Constants;
import graphics.Assets;

import java.awt.*;

public class MovePowerUp implements MovementStrategy{
    private int[] ghost_x, ghost_y;

    /**
     *  Constructor de la clase , asigna coordenadas correspondientes al que llama al metodo (fantasma).
     *  @param gx coordenada en "x" del fantasma
     *  @param gy coordenada en "y" del fantasma
     */
    public MovePowerUp(int[] gx, int[] gy){
        ghost_x = gx;
        ghost_y = gy;
    }

    /**
     *  Cambia el color del fantasma, lo que indica que el Pacman se lo puede comer.
     *  @param g graficos para dibujar en el canvas
     */
    public void changeColor(Graphics g){
        for(int i = 0; i < Constants.N_GHOSTS; i++){
            g.drawImage(Assets.blueGhost, ghost_x[i] + 1, ghost_y[i] + 1, null);
        }
    }
}
