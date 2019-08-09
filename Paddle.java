import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    int dx = 0;
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        dx = 0;
        if(Greenfoot.isKeyDown("left") == true){
            dx = - 4;
            setLocation(getX() + dx, getY());
        }
        if(Greenfoot.isKeyDown("right") == true){
            dx = 4;
            setLocation(getX() + dx, getY());
        }
        if(getX() + getImage().getWidth()/2 >= getWorld().getWidth()){
            dx = -4;
            setLocation(getX() + dx, getY());
        }
        if(getX() - getImage().getWidth()/2 <= 0){
            dx = 4;
            setLocation(getX() + dx, getY());
        }
    }    
}
