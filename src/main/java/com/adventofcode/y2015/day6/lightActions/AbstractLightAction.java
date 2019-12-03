package com.adventofcode.y2015.day6.lightActions;

import java.awt.Point;

public abstract class AbstractLightAction implements LightAction {
	
	private Point nwCorner = new Point(0,0);
	private Point seCorner = new Point(0,0);

	
	public void setNWCorner(Point nwCorner) {
		this.nwCorner = nwCorner;
	}

	
	public void setSECorner(Point seCorner) {
		this.seCorner = seCorner;
	}

	
	public Point getNWCorner() {
		return nwCorner;
	}

	
	public Point getSECorner() {
		return seCorner;
	}

}
