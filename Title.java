import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int num = 5;
    boolean on = true;
    int x = 0;
    public void act() 
    {
        if(x < 180 && on == true){
            turn(1);
            x += 1;
        }else{
            on = false;
            if(x < -180){
                on = true;
            }
            turn(-1);
            x += -1;
        }
    }
}
