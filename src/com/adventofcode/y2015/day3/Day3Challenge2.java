package com.adventofcode.y2015.day3;

import java.awt.Point;
import java.util.HashMap;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day3Challenge2 extends AbstractChallenge {

	private static final char NORTH = '^';
	private static final char EAST = '>';
	private static final char SOUTH = 'v';
	private static final char WEST = '<';

	private Point santaLocation = new Point();
	private Point roboSantaLocation = new Point();
	private HashMap<Point, Integer> santaMap = new HashMap<Point, Integer>();

	public Day3Challenge2() {
		initializeSantaLocation();
		initializeRoboSantaLocation();
		initializeSantaMap();
	}

	private void initializeSantaLocation() {
		santaLocation.setLocation(0, 0);
	}

	private void initializeRoboSantaLocation() {
		roboSantaLocation.setLocation(0, 0);
	}

	private void initializeSantaMap() {
		santaMap.putIfAbsent(getSantaLocation().getLocation(), 1);
	}

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			for( int i = 0; i < line.length(); i++ ) {
				if( i % 2 == 0 ) {
					moveSanta(line.charAt(i));
					recordVisit(getSantaLocation());
				}
				else {
					moveRoboSanta(line.charAt(i));
					recordVisit(getRoboSantaLocation());
				}
			}
		}
		return new Integer(santaMap.size()).toString();
	}

	private void moveSanta(char direction) {
		move(getSantaLocation(), direction);
		return;
	}

	private Point getSantaLocation() {
		return santaLocation;
	}

	private void move(Point location, char direction) {

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

	private void moveRoboSanta(char direction) {
		move(getRoboSantaLocation(), direction);
		return;
	}

	private Point getRoboSantaLocation() {
		return roboSantaLocation;
	}

	private void recordVisit(Point location) {
		Integer visitsToThisHouse = santaMap.get(getSantaLocation());
		if( visitsToThisHouse == null ) {
			visitsToThisHouse = 0;
		}
		santaMap.put(location.getLocation(), ++visitsToThisHouse);
		return;
	}
}
