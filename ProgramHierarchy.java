/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	/** Width of each box in pixels */
	private static final int BOX_WIDTH = 140;
	
	/** Height of each box in pixels */
	private static final int BOX_HEIGHT = 50;
	
	public void run() {
		int centerX = getWidth()/2;
		int centerY = getHeight()/2;
		int originX = centerX - BOX_WIDTH/2;
		int originY = centerY + BOX_HEIGHT/2;
		int i;
		//draw 4 boxes
		for(i=-1;i<=1;i++) {
			GRect box = new GRect(originX - i*(BOX_WIDTH + BOX_HEIGHT), originY, BOX_WIDTH, BOX_HEIGHT);
			add(box);
			//draw box named "Program"
			if(i==0) {
				GRect topBox = new GRect(originX, originY - 2*BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
				topBox.setColor(Color.RED);
				add(topBox);
			}
		}
		//label "GraphicsProgram"
		GLabel label1 = new GLabel("GraphicsProgram", centerX - BOX_WIDTH - BOX_HEIGHT, centerY + BOX_HEIGHT);
		label1.move(-label1.getWidth()/2, label1.getAscent()/2);
		add(label1);
		//label "Program"
		GLabel label2 = new GLabel("Program", centerX, centerY - BOX_HEIGHT);
		label2.move(-label2.getWidth()/2, label2.getAscent()/2);
		add(label2);
		//label "ConsoleProgram"
		GLabel label3 = new GLabel("ConsoleProgram", centerX, centerY + BOX_HEIGHT);
		label3.move(-label3.getWidth()/2, label3.getAscent()/2);
		add(label3);
		//label "DialogProgram"
		GLabel label4 = new GLabel("DialogProgram", centerX + BOX_WIDTH + BOX_HEIGHT, centerY + BOX_HEIGHT);
		label4.move(-label4.getWidth()/2, label4.getAscent()/2);
		add(label4);
		
		GLine line1 = new GLine(originX + BOX_WIDTH/2, originY - BOX_HEIGHT, centerX - BOX_WIDTH - BOX_HEIGHT, centerY + BOX_HEIGHT/2);
		add(line1);
		
		GLine line2 = new GLine(originX + BOX_WIDTH/2, originY - BOX_HEIGHT, centerX, centerY + BOX_HEIGHT/2);
		add(line2);
		
		GLine line3 = new GLine(originX + BOX_WIDTH/2, originY - BOX_HEIGHT, centerX + BOX_WIDTH + BOX_HEIGHT, centerY + BOX_HEIGHT/2);
		add(line3);
	}
}

