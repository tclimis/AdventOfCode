package com.adventofcode.y2015.day6.lightActions;

import java.awt.Point;

public abstract class AbstractLightAction implements LightAction {
	
	private Point nwCorner = new Point(0,0);
	private Point seCorner = new Point(0,0);

	@Override
	public void setNWCorner(Point nwCorner) {
		this.nwCorner = nwCorner;
	}

	@Override
	public void setSECorner(Point seCorner) {
		this.seCorner = seCorner;
	}

	@Override
	public Point getNWCorner() {
		return nwCorner;
	}

	@Override
	public Point getSECorner() {
		return seCorner;
	}

}
