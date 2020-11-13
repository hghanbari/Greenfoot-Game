import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    Rock rock1;
    int counter= 49;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600,1); 
        populateTheWorld();
        
    }
    protected void populateTheWorld()
    {   int teller;
        
        addObject( new Woman(),getWidth()/25,getHeight()/15);
        addObject( new Man(),getWidth()/2,getHeight()/2+250);
        addObject( new Snake(),(getWidth()/3),(getHeight()/2+200));
        addObject( new Snake(),(getWidth()/4),(getHeight()/6));
        addObject( new Snake(),(getWidth()/2+200),(getHeight()/2));
        addObject( new Snake(),(getWidth()/2+200),(getHeight()/4));
        for(teller = 0;teller < 4;teller++ ){
             addObject( new Rock(),getWidth()/10,getHeight()/20*teller);
        }
        rock1 = new Rock();
        addObject( new Rock() ,getWidth()/15,getHeight()/6);
        addObject(rock1,getWidth()/40,getHeight()/6);
        
        
        for(teller = 0; teller < 8; teller++ ){
           if(teller < 7){
             addObject( new Cactus(),getWidth()/6+(100*teller),getHeight()/15);  
          }              
             addObject( new Cactus(),getWidth()/20+(100*teller),getHeight()/3);
             addObject( new Cactus(),getWidth()/20+(100*teller),getHeight()/2+30);
             addObject( new Cactus(),getWidth()/20+(100*teller),getHeight()/2+160);          
           
        }
        for(teller = 0; teller < 10; teller++ ){
           if(teller < 9){
             addObject( new Bloem(),getWidth()/6+(80*teller),getHeight()/5-20);  
            }              
             addObject( new Bloem(),getWidth()/20+(80*teller),getHeight()/4);
             addObject( new Bloem(),getWidth()/20+(80*teller),getHeight()/3+70);
             addObject( new Bloem(),getWidth()/20+(80*teller),getHeight()/2+100);
             addObject( new Bloem(),getWidth()/20+(80*teller),getHeight()/2+240);          
        }
    }
}
