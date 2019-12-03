package com.adventofcode.y2018.day3;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day3Challenge1 extends AbstractChallenge {
	
	protected Map<Point, Integer> fabric;

	public void initialize() { 
		fabric = new HashMap<Point, Integer>();
	}
	
	public void processLine(String input) {	
		Rectangle rectangle = LineParser.getRectangle(input);
		fillPoints(rectangle);
	}
	
	protected void fillPoints(Rectangle rectangle) {
		Point corner = rectangle.getCorner();
		for( int i = corner.x; i < corner.x + rectangle.getWidth(); i++ ) {
			for( int j = corner.y; j < corner.y + rectangle.getHeight(); j++ ) {
				incrementPoint(new Point(i, j));
			}
		}
	}
	
	private void incrementPoint(Point point) {
		Integer value = (fabric.get(point) == null) ? 0 : fabric.get(point);
		fabric.put(point, value + 1);
	}
	
	public String getOutput() {
		return countOverlapPoints().toString();
	}
	
	private Integer countOverlapPoints() {
		Integer count = 0;
		for( Integer value : fabric.values() ) {
			if( value > 1 ) {
				count++;
			}
		}
		return count;
	}

}
