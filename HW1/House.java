/*************************************************************************
 *  ID: A1163016 
 *  NAME: Peter Tran 
 *  LOGIN: cs11ehc
 *
 *  Compilation:  javac -cp objectdraw.jar:. House.java
 *  Execution:    java -cp objectdraw.jar:. House
 *  Requires: objectdraw.jar
 *  About: Draws a house with a roof, sky, and grass. 
 *************************************************************************/
import objectdraw.*;
import java.awt.*;

public class House extends WindowController {
    public static final int FRAME_HEIGHT = 400;
    public static final int FRAME_WIDTH = 400;
    public static final int HOUSE_SIZE = 150;
    public static final int PADDING = 55;
    public static final double ROOF_LOCATION = 57.5;
    public static final double ARC_ANGLE = 180.0;

    /* The begin method is called automatically by Java after
     *  startController() is executed within the main() method. 
     *  You'll only need to add code within this function to
     *  complete the assignment. 
     */
    public void begin() {
	FilledRect grass = new FilledRect(0, FRAME_HEIGHT/2, FRAME_WIDTH, 
					  FRAME_HEIGHT/2, canvas);
	grass.setColor(new Color(0,255,0));
	
	FilledRect sky = new FilledRect(0, 0, FRAME_WIDTH,
					FRAME_HEIGHT/2, canvas);
	sky.setColor(new Color(0,0,255));

	FilledRect house = new FilledRect(FRAME_WIDTH/3, FRAME_HEIGHT/3,
					  HOUSE_SIZE, HOUSE_SIZE, canvas);
	house.setColor(new Color(255,0,0));
	
	FilledArc arc = new FilledArc(FRAME_WIDTH/3, ROOF_LOCATION, HOUSE_SIZE,
				      HOUSE_SIZE, 0.0, ARC_ANGLE, canvas);
	arc.setColor(new Color(255,255,0));
	
    }
    
    
    public static void main(String[] args) {	 
	new House().startController(FRAME_WIDTH, FRAME_HEIGHT + PADDING);
	return;
    } 
}
