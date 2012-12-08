/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		int centerX = getWidth()/2;
		int centerY = getHeight();
		int i, k = BRICKS_IN_BASE;
		int originX;
		int originY = centerY - BRICK_HEIGHT;
		while(k>0) {
			for(i=0;i<=k-1;i++) {
				originX = centerX - (k/2)*BRICK_WIDTH - (k%2)*(BRICK_WIDTH/2);
				GRect brick = new GRect(originX + i*BRICK_WIDTH, originY, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				if((k%2) == 0) {
					brick.setFillColor(Color.YELLOW);
				}
				else {
					brick.setFillColor(Color.GREEN);
				}
				add(brick);
			}
			k--;
			originY = originY - BRICK_HEIGHT;
		}
	}
}

