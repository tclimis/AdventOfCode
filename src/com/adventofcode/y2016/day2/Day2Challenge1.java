package com.adventofcode.y2016.day2;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {

	private Point location;
	private Map<Point, String> numberMap;

	private static final Point ONE = new Point(0, 2);
	private static final Point TWO = new Point(1, 2);
	private static final Point THREE = new Point(2, 2);
	private static final Point FOUR = new Point(0, 1);
	private static final Point FIVE = new Point(1, 1);
	private static final Point SIX = new Point(2, 1);
	private static final Point SEVEN = new Point(0, 0);
	private static final Point EIGHT = new Point(1, 0);
	private static final Point NINE = new Point(2, 0);

	@Override
	public String execute(String inputFile) {
		String code = "";
		setLocation(FIVE);
		setupNumberMap();
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			code += getNumberFromLine(line);
		}
		return code;
	}

	private void setupNumberMap() {
		numberMap = new HashMap<Point, String>();
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

	private Map<Point, String> getNumberMap() {
		return numberMap;
	}

	private void setLocation(Point location) {
		this.location = location;
	}

	private String getNumberFromLine(String line) {
		for( int i = 0; i < line.length(); i++ ) {
			char direction = line.charAt(i);
			move(direction);
		}
		return getNumber();
	}

	private void move(char direction) {
		// move
		switch( direction ) {
			case 'U':
				getLocation().translate(0, 1);
				break;
			case 'R':
				getLocation().translate(1, 0);
				break;
			case 'D':
				getLocation().translate(0, -1);
				break;
			case 'L':
				getLocation().translate(-1, 0);
				break;
		}

		// bound
		if( getLocation().x < 0 ) {
			getLocation().x = 0;
		}
		if( getLocation().x > 2 ) {
			getLocation().x = 2;
		}
		if( getLocation().y < 0 ) {
			getLocation().y = 0;
		}
		if( getLocation().y > 2 ) {
			getLocation().y = 2;
		}
	}

	private String getNumber() {
		return getNumberMap().get(getLocation());
	}

	private Point getLocation() {
		return location;
	}
}
