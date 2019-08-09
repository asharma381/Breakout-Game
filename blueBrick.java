import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blueBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blueBrick extends Brick
{
    private int numHits = 0;
    /**
     * Act - do whatever the blueBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         if(isHit()){
            numHits++;
            if(numHits == 1){
                setImage("brick028.png");
            }
            if(numHits == 2){
                getWorld().removeObject(this); 
            }
        }
    }    
}
