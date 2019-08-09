import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class greenBrick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class greenBrick extends Brick
{
    private int numHits = 0;
    /**
     * Act - do whatever the greenBrick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //super.act();
        if(isHit()){
            numHits++;
            if(numHits == 1){
                setImage("brick011.png");
            }
            if(numHits == 2){
                getWorld().removeObject(this); 
            }
        }
    }    
    /*public void onHit(){
        int numHits = getNumHits();
        setNumHits(numHits + 1);
        
        if(numHits == 1){
            setImage("brick017.png");
        }else{
            super.onHit();
        }
    }*/
}