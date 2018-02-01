package com.adventofcode.y2015.day3;

import java.awt.Point;
import java.util.HashMap;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day3Challenge1 extends AbstractChallenge {

	private static final char NORTH = '^';
	private static final char EAST = '>';
	private static final char SOUTH = 'v';
	private static final char WEST = '<';

	private Point santaLocation = new Point();
	private HashMap<Point, Integer> santaMap = new HashMap<Point, Integer>();

	public Day3Challenge1() {
		initializeSantaLocation();
		initializeSantaMap();
	}

	private void initializeSantaLocation() {
		santaLocation.setLocation(0, 0);
	}

	private void initializeSantaMap() {
		santaMap.putIfAbsent(getSantaLocation().getLocation(), 1);
	}

	private Point getSantaLocation() {
		return santaLocation;
	}

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			for( int i = 0; i < line.length(); i++ ) {
				moveSanta(line.charAt(i));
				recordVisit();
			}
		}
		return new Integer(santaMap.size()).toString();
	}

	protected void moveSanta(char direction) {
		switch( direction ) {
			case NORTH:
				getSantaLocation().move(getSantaLocation().x, getSantaLocation().y + 1);
				return;
			case EAST:
				getSantaLocation().move(getSantaLocation().x + 1, getSantaLocation().y);
				return;
			case SOUTH:
				getSantaLocation().move(getSantaLocation().x, getSantaLocation().y - 1);
				return;
			case WEST:
				getSantaLocation().move(getSantaLocation().x - 1, getSantaLocation().y);
				return;
			default:
				return;
		}
	}

	private void recordVisit() {
		Integer visitsToThisHouse = santaMap.get(getSantaLocation());
		if( visitsToThisHouse == null ) {
			visitsToThisHouse = 0;
		}
		santaMap.put(getSantaLocation().getLocation(), ++visitsToThisHouse);
		return;
	}
}
