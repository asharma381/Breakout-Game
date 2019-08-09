import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends Actor
{
    int x = 0;
    boolean on = true;
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(x < 180 && on == true){
            turn(2);
            x += 2;
        }else{
            on = false;
            if(x < -180){
                on = true;
            }
            turn(-2);
            x += -2;
        } 
    }      
}
