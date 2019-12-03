package com.adventofcode.y2018.day3;

import java.awt.Point;

public class Rectangle {
	
	private Integer id;
	private Point corner;
	private Integer width;
	private Integer height;
	
	public Rectangle(String id, String x, String y, String width, String height) {
		try {
			setID(Integer.valueOf(id));
			setCorner(new Point(Integer.parseInt(x), Integer.parseInt(y)));
			setWidth(Integer.valueOf(width));
			setHeight(Integer.valueOf(height));
		}
		catch( NumberFormatException e ) {
			setID(Integer.valueOf(0));
			setCorner(new Point(0,0));
			setWidth(Integer.valueOf(0));
			setHeight(Integer.valueOf(0));
		}
	}
	
	private void setID(Integer id) {
		this.id = id;
	}
	
	private void setCorner(Point corner) {
		this.corner = corner;
	}
	
	private void setWidth(Integer width) {
		this.width = width;
	}
	
	private void setHeight(Integer height) {
		this.height = height;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public Point getCorner() {
		return this.corner;
	}
	
	public Integer getWidth() {
		return this.width;
	}
	
	public Integer getHeight() {
		return this.height;
	}

}
