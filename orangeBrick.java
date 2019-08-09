import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class orangeBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class orangeBrick extends Brick
{
    /**
     * Act - do whatever the orangeBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int numHits = 0;
    public void act() 
    {
        // Add your action code here.
                 if(isHit()){
            numHits++;
            if(numHits == 1){
                getWorld().removeObject(this); 
            }
        }
    }    
}
