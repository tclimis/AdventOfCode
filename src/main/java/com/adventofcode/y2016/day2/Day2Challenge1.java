package com.adventofcode.y2016.day2;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {

	private Point location;
	protected Map<Point, String> numberMap;
	private String code;

	private static final Point ONE = new Point(0, 2);
	private static final Point TWO = new Point(1, 2);
	private static final Point THREE = new Point(2, 2);
	private static final Point FOUR = new Point(0, 1);
	private static final Point FIVE = new Point(1, 1);
	private static final Point SIX = new Point(2, 1);
	private static final Point SEVEN = new Point(0, 0);
	private static final Point EIGHT = new Point(1, 0);
	private static final Point NINE = new Point(2, 0);

	public void initialize() {
		this.code = "";
		setLocation(FIVE);
		setupNumberMap();
	}
	
	private void setLocation(Point location) {
		this.location = location;
	}
	
	protected void setupNumberMap() {
		numberMap = new HashMap<>();
		getNumberMap().putIfAbsent(ONE, "1");
		getNumberMap().putIfAbsent(TWO, "2");
		getNumberMap().putIfAbsent(THREE, "3");
		getNumberMap().putIfAbsent(FOUR, "4");
		getNumberMap().putIfAbsent(FIVE, "5");
		getNumberMap().putIfAbsent(SIX, "6");
		getNumberMap().putIfAbsent(SEVEN, "7");
		getNumberMap().putIfAbsent(EIGHT, "8");
		getNumberMap().putIfAbsent(NINE, "9");
	}

	protected Map<Point, String> getNumberMap() {
		return numberMap;
	}
	
	public void processLine(String input) {
		code += getNumberFromLine(input);
	}

	private String getNumberFromLine(String line) {
		for( int i = 0; i < line.length(); i++ ) {
			char direction = line.charAt(i);
			move(direction);
		}
		return getNumber();
	}

	private void move(char direction) {
		Point testMove = new Point(getLocation());
		// move
		switch( direction ) {
			case 'U':
				testMove.translate(0, 1);
				break;
			case 'R':
				testMove.translate(1, 0);
				break;
			case 'D':
				testMove.translate(0, -1);
				break;
			case 'L':
				testMove.translate(-1, 0);
				break;
			default: 
				// do nothing
		}

		// bound
		if( getNumberMap().containsKey(testMove) ) {
			setLocation(testMove);
		}
	}

	private String getNumber() {
		return getNumberMap().get(getLocation());
	}

	private Point getLocation() {
		return location;
	}
	
	public String getOutput() {
		return code;
	}
	
}
