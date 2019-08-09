import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Color f;
    Color b;
    Color o;
    String s;
    int size;
    boolean isPressed = false;
    int time = 0;
    int x = 0;
    GreenfootImage img;
    
     public Text(java.lang.String txt, int size, Color fontC, Color back, Color outline){
        s = txt;
        this.size = size;
        f = fontC;
        b = back;
        o = outline;
        
        updateImage();
        
    }
    
        
    public void updateImage(){
        img = new GreenfootImage(s,size,b,f,o);
        setImage(img);
    }
  
    
    public void act() 
    {
        // Add your action code here.
    }    
}
