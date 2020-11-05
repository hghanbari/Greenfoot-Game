import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int random;
       
       move(5);
       if(atWorldEdge()){
           move(-5);
           if(Greenfoot.getRandomNumber(100)<50){
              setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            } 
            else {
                 setRotation(getRotation() - Greenfoot.getRandomNumber(180));
           }
       } 
       else{
           random = Greenfoot.getRandomNumber(100);
           if(random < 2) {
              setRotation(getRotation() + Greenfoot.getRandomNumber(180));
           }
           if(random > 98) {
              setRotation(getRotation() - Greenfoot.getRandomNumber(180));
           }
       } 
       lookforActor();
       lookforGrarp();
    } 
    
    public boolean atWorldEdge() 
    {
        int x, i, y, wx, wy;

        x = getX();
        i = getImage().getWidth() / 2;
        // Linkerkant
        if (x <= i) {
            return true;
        }
        //Bovenkant
        y = getY();
        if (y <= i) {
            return true;
        }
        //Rechterkant
        wx = getWorld().getWidth() - i;
        if (x >= wx) {
            return true;
        }
        //Onderkant
        wy = getWorld().getWidth() - i;
        if (y >= wy) {
            return true;
        }
        return false;
    }
    
    protected void lookforActor(){
        Actor actor;
        actor = getOneObjectAtOffset(1, 1,Actor.class);
        if(actor != null){
            turn(90);
        }
    }
    protected void lookforGrarp()
    {
        Actor garp;
        
        int num = 0;
        garp = getOneObjectAtOffset(1,1,Garp.class);
       
        if(garp != null){
            Greenfoot.playSound("scream.mp3");
            getWorld().removeObject(garp);
            Greenfoot.stop();
        }
                
    }
}   
