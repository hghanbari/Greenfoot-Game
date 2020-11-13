import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Actor
{
     private GreenfootImage imageLeft = new GreenfootImage("ManLeft.png");
     private GreenfootImage imageRight = new GreenfootImage("ManRight.png");
      
    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        collectingBloem();
        movingAndTurning();
        fundCactus();
        foundRock();
    }
    
    protected void movingAndTurning(){
      if(Greenfoot.isKeyDown("right")){   
        if(getImage() == imageRight){
            setImage(imageLeft);
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
        if(foundRock())
        {
            move(-5);
        }
      } 
    }
    
    protected void collectingBloem()
    {
        Actor bloem;
        
        bloem = getOneObjectAtOffset(0,0,Bloem.class);
        if(bloem != null)
        {
          getWorld().removeObject(bloem);
          MyWorld myworld = (MyWorld)getWorld();
          myworld.counter--;
          
          if (myworld.counter == 0)
          {
            myworld.removeObject(myworld.rock1);
            }
          
        }
 
    }
    
     protected boolean foundRock(){
       Actor Rock;
       Rock = getOneObjectAtOffset(1,1,Rock.class);
       if(Rock != null)
       {
           return true;
       }
    
       return false;
    }
    
    protected boolean fundCactus()
    {
        Actor cactus;
        cactus = getOneObjectAtOffset(0, 0,Cactus.class);
        if(cactus != null)
        {
            Greenfoot.playSound("Funny-Scream.mp3");
            getWorld().addObject(new Gameover(),400,500);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
        return true;
    }
}

