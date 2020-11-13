import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       int random;
   
       move(1);
       if(atWorldEdge()){
           move(-1);
           if(Greenfoot.getRandomNumber(100) > 50){
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
       lookforMan();
       lookforRock();
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
    protected void lookforRock(){
        Actor rock;
        
        rock = getOneObjectAtOffset(1, 1,Rock.class);
        if(rock != null){
            turn(45);
        }
    }
     
    protected void lookforMan()
    {
        Actor man;
       
        man = getOneObjectAtOffset(1,1,Man.class);
        if(man != null ){
            Greenfoot.playSound("Funny-Scream.mp3");
            getWorld().removeObject(man);
            getWorld().addObject(new Gameover(),getX(),getY());
            Greenfoot.stop();
        } 
    }
}
