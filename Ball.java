import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dx = 2;
    int dy = 2;
    public void act() 
    {
        //turn(10);
        setLocation(getX() + dx, getY() + dy);
        if(getY() + getImage().getHeight()/2 >= getWorld().getHeight()){
            
            dy = -dy;
        }
        if(getX() + getImage().getWidth()/2 >= getWorld().getWidth()){
            dx = -dx;
        }
        if(getY() - getImage().getHeight()/2 <= 0){
            dy = -dy;
        }
        if(getX() - getImage().getHeight()/2 <= 0){
            dx= -dx;
        }
        if(isTouching(Paddle.class) == true){
            dy = -dy;
            setLocation(getX() + dx, getY() + dy - 1);
        }
        if(isTouching(Brick.class) == true){
            dy = -dy;
        }
        
        Brick brick = (Brick) getOneIntersectingObject(Brick.class);
       ///;'///// brick.isHit();
        
        
    }    
}
