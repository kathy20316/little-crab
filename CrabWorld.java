

import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    private GreenfootImage backgroundImage;
    public CrabWorld() 
    {
        super(560, 560, 1);
        backgroundImage = new GreenfootImage("Beach.jpg");
        setBackground(backgroundImage);
        populateWorld();
    }
    
    public void populateWorld() {
        addObject(new Crab(), Greenfoot.getRandomNumber(getWidth()), 
            Greenfoot.getRandomNumber(getHeight()));
        for (int i = 0; i < 3; i++) {
            addObject​(new Lobster(), Greenfoot.getRandomNumber(getWidth()), 
            Greenfoot.getRandomNumber(getHeight()));
        }        
        for (int i = 0; i < 10; i++) {
            addObject(new Worm(), Greenfoot.getRandomNumber(getWidth()), 
            Greenfoot.getRandomNumber(getHeight()));
        }
        for (int i = 0; i < 5; i++) {
            addObject(new Starfish(), Greenfoot.getRandomNumber(getWidth()), 
            Greenfoot.getRandomNumber(getHeight()));
        }
    }
}
