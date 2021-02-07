import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms 
 * (very yummy, especially the green ones).
 * 
 * Version: 4
 * 
 * The crab is keyboard controlled and eats worms. In this version, we have added
 * a sound when the crab eats a worm.
 */

public class Crab extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormEaten;
    private int switchCycle;
    public Crab() {
        image1 = new GreenfootImage("images/crab.png");
        image2 = new GreenfootImage("images/crab2.png");        
        setImage(image1);
        wormEaten = 0;
        switchCycle = 0;
    }
    public void switchImage() {
        if (switchCycle < 5) {
            switchCycle++;
            return;
        }
        switchCycle = 0;
        if (getImage() == image1) {
            setImage(image2);
        }
        else {
            setImage(image1);
        }
    }
    /** 
     * Act - do whatever the crab wants to do. This method is called whenever
     *  the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeypress();
        //move(5);
        lookForWorm();
        switchImage();
    }
    
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            move(-5);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            move(5);
        }
        if (Greenfoot.isKeyDown("up") ){
            turn(-25);
        }
        if (Greenfoot.isKeyDown("down") ){
            turn(25);
        }
    }
    
    /**
     * Check whether we have stumbled upon a worm.
     * If we have, eat it. If not, do nothing.
     */
    public void lookForWorm()
    {
        if ( isTouching(Worm.class) ) 
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            wormEaten = wormEaten + 1;            
        }
        if (wormEaten == 8) {            
            Greenfoot.playSound("sounds/fanfare.wav");
            Greenfoot.stop();
        }        
    }
}