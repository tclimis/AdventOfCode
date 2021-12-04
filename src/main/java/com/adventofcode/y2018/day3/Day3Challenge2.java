package com.adventofcode.y2018.day3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Day3Challenge2 extends Day3Challenge1 {
	
	private List<Rectangle> rectangles;
	
	@Override
	public void initialize() {
		super.initialize();
		rectangles = new ArrayList<>();
	}
	
	@Override
	protected void fillPoints(Rectangle rectangle) {
		rectangles.add(rectangle);
		
		Point corner = rectangle.getCorner();
		for( int i = corner.x; i < corner.x + rectangle.getWidth(); i++ ) {
			for( int j = corner.y; j < corner.y + rectangle.getHeight(); j++ ) {
				assignPoint(new Point(i, j), rectangle.getID());
			}
		}
	}
	
	private void assignPoint(Point point, Integer id) {
		Integer value = (fabric.get(point) == null) ? id : 0;
		fabric.put(point, value);
	}

	@Override
	public String getOutput() {
		for( Rectangle rectangle : rectangles ) {
			if( rectangle.getHeight() * rectangle.getWidth() == countSpaces(rectangle.getID()) ) {
				return rectangle.getID().toString();
			}
		}
		return "no rectangle found";
	}
	
	private Integer countSpaces(Integer id) {
		Integer count = Integer.valueOf(0);
		for( Integer value : fabric.values() ) {
			if( value.equals(id) ) {
				count++;
			}
		}
		return count;
	}

}
