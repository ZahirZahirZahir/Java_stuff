/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		int centerX = getWidth()/2;
		int centerY = getHeight()/2;
		int diameter, originX, originY, i;
		for(i=0;i<=2;i++) {
			if(i==0) {
				diameter = 144;
				originX = centerX-diameter/2;
				originY = centerY-diameter/2;
			}
			else if(i==1) {
				diameter = 94;
				originX = centerX-diameter/2;
				originY = centerY-diameter/2;
			}
			else {
				diameter = 43;
				originX = centerX-diameter/2;
				originY = centerY-diameter/2;
			}
			GOval oval = new GOval(originX,originY,diameter,diameter);
			oval.setFilled(true);
			if(i!=1) {
				oval.setColor(Color.RED);
			}
			else {
				oval.setColor(Color.WHITE);
			}
//			oval.setFillColor(Color.RED);
			add(oval);
		}

	}
}
