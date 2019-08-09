import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int titleBreakout = -1;
    private final int title = 0;
    private final int intro = 100;
    private final int PLAYING = 1;
    private int state = titleBreakout;
    private int level = 0;
    private int x = 0;
    private int a = 0;
    private int b = 0;
         
    private final int NORMAL_BRICK = 1;
    private final int GREEN_BRICK = 2;
    private final int BLUE_BRICK = 3;
    private final int ORANGE_BRICK = 4;
    
    private Text timer = new Text("Welcome To The Breakout Game", 40, Color.white, Color.black, Color.blue);
    private Text timer1 = new Text("The objective of the game is to bounce the ball off", 25, Color.black, Color.blue, Color.blue);
    private Text timer2 = new Text("the paddle while hitting the bricks. Once all", 25, Color.black, Color.blue, Color.blue);;
    private Text timer3 = new Text("the bricks are taken down, you will be moved", 25,Color.black, Color.blue, Color.blue);
    private Text timer4 = new Text("to the next level. There are 3 level in the game", 25,Color.black, Color.blue, Color.blue);
    private Text timer5 = new Text("Enjoy!", 25,Color.black, Color.blue, Color.blue);
    private Text start = new Text("Press S to start game", 25,Color.black, Color.blue, Color.white);
    private Text start2 = new Text("Press Space to re-start game", 25,Color.black, Color.blue, Color.white);
    private Text start3 = new Text("Press Space to play again", 25,Color.black, Color.blue, Color.white);
    private Text sGame = new Text("Click the screen to start playing", 25, Color.black, Color.blue, Color.white);
    private Text space = new Text("Press space to show the instructions", 25, Color.black, Color.blue, Color.white);
    private Text S = new Text("Press S to start game", 25, Color.black, Color.blue, Color.white);
    
    Title t = new Title();
    Ball ball = new Ball();
    Paddle paddle = new Paddle();
    GameOver gOver = new GameOver();
    YouWin win = new YouWin();
   public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels
        super(600, 400, 1); 
        
        addObject(t,getWidth()/2, getHeight()/2);
        addObject(sGame, getWidth()/2, 320);
    }
    
   public void act() {
       if(state == titleBreakout){
           if(a % 5 == 0){
           if(x == 0){
               removeObject(sGame);
               x= 1;
            }else if(x == 1){
               addObject(sGame, getWidth()/2, 320);
                //b = 1;
                x = 0;
            }
        }
            a++;
           if(Greenfoot.mouseClicked(this)){
              removeObject(sGame);
              addObject(space, getWidth()/2, 320);
              addObject(S, getWidth()/2, 350);
              state = title;
            }
       }
       if(state == title){
           removeObject(gOver);
           removeObject(start);
           removeObject(win);
            if(Greenfoot.isKeyDown("space")){
                removeObject(t);
               removeObject(space);
               removeObject(S);
                state = intro;
            }
            if(Greenfoot.isKeyDown("s")){
                state = PLAYING;
                removeObject(t);
                removeObject(space);
               removeObject(S);
            }
        }else if(state == intro){
           
            addObject(timer, 300, 50);
            addObject(timer1, 300,100);
            addObject(timer2, 300,150);
            addObject(timer3, 300,200);
            addObject(timer4, 300, 250);
            addObject(timer5, 300,300);
            addObject(start, getWidth()/2, 350);

            if(Greenfoot.isKeyDown("s")){
                removeObject(timer);
                removeObject(timer1);
                removeObject(timer2);
                removeObject(timer3);
                removeObject(timer4);
                removeObject(timer5);
                removeObject(start);
                state = PLAYING;
    
            }
        }else if(state == PLAYING && level == 0){
            
            //adds the ball
            ball.getImage().scale(25,25);
            addObject(ball, getWidth()/2, getHeight()/2);
            addObject(paddle, getWidth()/2, getHeight() - paddle.getImage().getHeight()/2);
              
            // this code below is for creating level 1
            createOneRow(30,20,9,ORANGE_BRICK);
            createOneRow(30,40,9,BLUE_BRICK);
            createOneRow(30,60,9,NORMAL_BRICK);
            createOneRow(30,80,9,GREEN_BRICK);  
            level = 1;   
        }else if(level == 1){
              List brickL = getObjects(Brick.class);
            if(ball.getY() + ball.getImage().getHeight()/2 >= getHeight()){
                List objects = getObjects(null);
                removeObjects(objects);
                level = 4;
            }
             
                if(brickL.isEmpty()){ 
                
                // the code below is for level 2
                createRowsWithSpace(20, 20, 9, 4, ORANGE_BRICK,BLUE_BRICK);
                
                // Set the ball to the middle of the screen
                removeObject(ball);
                addObject(ball,getWidth()/2, getHeight()/2);
                level++;
            }
        }else if(level == 2){
            List brickL2 = getObjects(Brick.class);
            if(brickL2.isEmpty()){
                 //the code below is for level 3
                 createRows(20,20,9,4, GREEN_BRICK);
                 
                 // Set the ball to the middle of the screen
                 removeObject(ball);
                 addObject(ball,getWidth()/2, getHeight()/2);
                 level++;
            }
            
            if(ball.getY() + ball.getImage().getHeight()/2 >= getHeight()){
                List objects = getObjects(null);
                removeObjects(objects);
                level = 4;
            }
            
        }else if(level == 3){
            List brickL3 = getObjects(Brick.class);
            if(brickL3.isEmpty()){
                addObject(win,getWidth()/2, getHeight()/2);
                addObject(start3, getWidth()/2, 350);
                removeObject(paddle);
                removeObject(ball);
               
                if(Greenfoot.isKeyDown("space")){
                     removeObject(start3);
                     removeObject(start);
                     level = 0;
                     state = title;
                 }
            }
        }else if(level == 4){
            addObject(start2, getWidth()/2, 350);
                addObject(gOver,getWidth()/2, getHeight()/2);
                removeObject(paddle);
                removeObject(ball);
            if(Greenfoot.isKeyDown("space")){
                removeObject(start2);
                level = 0;
                state = title;
            }
        }
    }

   private void createRows(int x, int y, int length, int height, int type){
        Brick tmpBrick2 = new Brick();
        int h =  tmpBrick2.getImage().getHeight(); 
        for(int i = 0; i < height; i++){
            int width = tmpBrick2.getImage().getHeight();
            createOneRow(x, y + i*h, length, type);
        }
    }
    
   private void createRowsWithSpace(int x, int y, int length, int height, int type, int type2){    
       Brick tmpBrick2 = new Brick();
       int h =  tmpBrick2.getImage().getHeight(); 
       int num = 0;
       for(int i = 0; i < height; i++){
           int width = tmpBrick2.getImage().getHeight();
           if(num % 2 == 0){
               createOneRow(x, y + i*h, length, type);
           }else{
                createOneRow(x + 2 * width, y + i*h, length, type2);
           }
           num++;
       }
    }
    
   private void createOneRow(int x, int y, int length, int type){ // Brick localBrick){
       // making a tmp object to find the width of the brick
       Brick tmpBrick = new Brick();
       int width2 =  2* tmpBrick.getImage().getWidth();
       for(int i = 0; i < length; i++){
           createOneBrick(x+i*width2, y, type);
       }
        }
     
   private void createOneBrick(int x, int y, int type) {
       if(type == 1){
           Brick brick = new Brick();
           addObject(brick,x,y);
       }else if(type == 2){
          greenBrick brick = new greenBrick();
           addObject(brick,x,y);
       }else if(type == 3){
           blueBrick brick = new blueBrick();
           addObject(brick,x,y);
       }else if(type == 4){
           orangeBrick brick = new orangeBrick();
           addObject(brick,x,y);
       }
    }
}