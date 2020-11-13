import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Grap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{   
      private GreenfootImage imageLeft = new GreenfootImage("GarpLeft.png");
      private GreenfootImage imageRight = new GreenfootImage("GarpRight.png");
     /**
     * Act - do whatever the Grap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
       movingAndTurning(); 
       collectingDiamond();
       foundRock();
       fundBomb1();
    }
    
    protected void movingAndTurning(){
      if(Greenfoot.isKeyDown("right")){   
        if(getImage() == imageLeft){
            setImage(imageRight);
        }
        setRotation(0);
        move(5);
        if(foundRock())
        {
            move(-5);
        } 
      }
      if(Greenfoot.isKeyDown("left")) {     
        if(getImage() == imageRight){
             setImage(imageLeft);
        }
        setRotation(180);
        move(5);
        if(foundRock())
        {
            move(-5);
        } 
      }
      if(Greenfoot.isKeyDown("up")){   
        if(getImage() == imageLeft){
            setImage(imageRight);
        }
        setRotation(-90);
        move(5);
        if(foundRock())
        {
            move(-5);
        } 
      } 
      if(Greenfoot.isKeyDown("down")){     
        if(getImage() == imageLeft){
            setImage(imageRight);
        } 
        setRotation(90); 
        move(5); 
        if(foundRock    ())
        {
            move(-5);
        } 
      } 
    }
    
    protected void collectingDiamond()
    {
        Actor diamond;
        World world;
        Counter counter;
        List lijst;
        
        diamond = getOneObjectAtOffset(0,0,Diamond.class);
        if(diamond != null)
        {
          world = getWorld();
          world.removeObject(diamond);
          lijst = world.getObjects(Counter.class);
          counter = (Counter)lijst.get(0);
          counter.addScore();
          if(counter.getScore() == 10)
          {
              Greenfoot.stop();
          }
        }
    }
    
    protected boolean foundRock(){
       Actor rock;
       rock = getOneObjectAtOffset(0,0,Rock.class);
       if(rock != null)
       {
           return true;
        }
       return false;
    }
    
    protected boolean fundBomb1()
    {
        Actor bomb;
        bomb = getOneObjectAtOffset(0, 0,Bomb.class);
        if(bomb != null)
        {
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(),getX(),getY());
            getWorld().removeObject(this);
            //().serObject(charsDied++);
        }
        return true;
    }
    //public int getCharsDied()
    //{   
    // return this.charsDiedBomb;
    //}
} 

