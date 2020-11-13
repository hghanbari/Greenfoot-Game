import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Woman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Woman extends Actor
{
    /**
     * Act - do whatever the Woman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fundMan();
    }    
    
    protected boolean fundMan()
    {
        Actor man;
        man = getOneObjectAtOffset(0, 0,Man.class);
        if(man != null)
        {
            Greenfoot.playSound("2kiss.wav");
            getWorld().addObject(new Love(),getX()+150,getY()+80); 
            Greenfoot.stop();
        }
        return true;
    }
}
