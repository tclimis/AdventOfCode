package com.adventofcode.y2015.day3;

import java.awt.Point;
import java.util.HashMap;

import com.adventofcode.AbstractChallenge;

public class Day3Challenge1 extends AbstractChallenge {

	private static final char NORTH = '^';
	private static final char EAST = '>';
	private static final char SOUTH = 'v';
	private static final char WEST = '<';

	private Point santaLocation = new Point();
	private HashMap<Point, Integer> santaMap = new HashMap<>();

	public void initialize() {
		initializeSantaLocation();
		initializeSantaMap();
	}

	private void initializeSantaLocation() {
		santaLocation.setLocation(0, 0);
	}

	private void initializeSantaMap() {
		santaMap.putIfAbsent(getSantaLocation().getLocation(), 1);
	}

	protected Point getSantaLocation() {
		return santaLocation;
	}
	
	public void processLine(String input) {
		for( int i = 0; i < input.length(); i++ ) {
			moveSanta(input.charAt(i));
			recordVisit(getSantaLocation());
		}
	}

	protected void moveSanta(char direction) {
		move(getSantaLocation(), direction);
	}
	
	protected void move(Point location, char direction) {
		switch( direction ) {
			case NORTH:
				location.move(location.x, location.y + 1);
				return;
			case EAST:
				location.move(location.x + 1, location.y);
				return;
			case SOUTH:
				location.move(location.x, location.y - 1);
				return;
			case WEST:
				location.move(location.x - 1, location.y);
				return;
			default:
				return;
		}
	}

	protected void recordVisit(Point location) {
		Integer visitsToThisHouse = santaMap.get(getSantaLocation());
		if( visitsToThisHouse == null ) {
			visitsToThisHouse = 0;
		}
		santaMap.put(location.getLocation(), ++visitsToThisHouse);
	}
	
	public String getOutput() {
		return String.valueOf(santaMap.size());
	}

}
