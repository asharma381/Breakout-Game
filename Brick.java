import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Actor
{
    
    int numHits = 0;
    boolean touchingBrick = false;
    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //turn(3);
        if(isHit()){
            numHits++;
            if(numHits == 1){
            getWorld().removeObject(this);
            }
        }
    }
    public int getNumHits(){
        return numHits;
    }
    public void setNumHits(int val){
        numHits = val;
    }
   /* public void onHit(){
        //int numHits();
        getWorld().removeObject(this);
    }*/
    public boolean isHit(){
        if(isTouching(Ball.class)){
            return true;
        }else{
            return false;
        }
    }
}
