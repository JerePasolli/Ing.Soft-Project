package constants;

import java.awt.*;

public class Constants {
    public static final int CANVAS_WIDTH = 361, CANVAS_HEIGHT = 390;
    public static final int FRAME_WIDTH = 361, FRAME_HEIGHT = 421;
    public static final double FPS = 60;
    public static double TARGETTIME = 1000000000/FPS;
    public static final int BLOCK_SIZE = 24;
    public static final int N_BLOCKS = 15;
    public static final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    public static final int MAX_GHOSTS = 12;
    public static final int PACMAN_SPEED = 2;
    public static final int GHOST_SPEED = 2;
    public static final Font smallFont = new Font("Arial", Font.BOLD, 14);
    public static int N_GHOSTS = 6;
    public static final String PLAY = "PLAY";
    public static final String EXIT = "EXIT";
    public static final String RETURN = "RETURN";
    public static final String HIGH_SCORES = "HIGH SCORES";
    public static final String SCORE = "SCORE";
    public static final String DATE = "DATE";
    public static final String HELP = "HELP";
    public static final String HELPLINE1 = "Controles: Flechas del teclado";
    public static final String HELPLINE2 = "Objetivo: Comer todos los puntos blancos del escenario";
    public static final String HELPLINE3 = "Colisionar con un fantasma le hará perder una vida";
    public static final String HELPLINE4 = "Cuenta con 3 vidas, al perder todas finaliza el juego";

}
