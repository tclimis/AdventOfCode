package com.adventofcode.y2015.day6.light_actions;

import java.awt.Point;

public interface LightAction {
	
	public void setNWCorner(Point nwCorner);
	public void setSECorner(Point seCorner);
	public Point getNWCorner();
	public Point getSECorner();
	public void execute( int[][] lightField );

}
