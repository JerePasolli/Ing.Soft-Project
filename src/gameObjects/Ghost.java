package gameObjects;

import states.GameState;
import java.awt.Graphics;
import java.awt.Image;

import constants.Constants;

public class Ghost extends GameObject{
    private int deqx,deqy,speed;
    public Ghost(int x,int y,Image texture, GameState gameState,int speed){
        super(x,y,texture,gameState);
        this.dx=0;
        this.dy=0;
    }

   @Override
   public void update(){
        moveGhost();
   }

   @Override
   public void draw(Graphics g) {
       
   }
   public void setSpeed(int speed){
        this.speed=speed;
   }

   public void moveGhost(){
        int pos,count;
        if(this.x % Constants.BLOCK_SIZE==0 && this.y % Constants.BLOCK_SIZE==0){
            pos=this.x/Constants.BLOCK_SIZE+Constants.N_BLOCKS*(int) (this.y/Constants.BLOCK_SIZE);
            count=0;
            if((gameState.getScreenData()[pos] & 1)==0 && this.dx!=1){
                
            }

        }
   }

}
