package com.adventofcode.y2016.day2;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day2Challenge2 extends AbstractChallenge {

	private Point location;
	private Map<Point, String> numberMap;

	private static final Point ONE = new Point(2, 4);
	private static final Point TWO = new Point(1, 3);
	private static final Point THREE = new Point(2, 3);
	private static final Point FOUR = new Point(3, 3);
	private static final Point FIVE = new Point(0, 2);
	private static final Point SIX = new Point(1, 2);
	private static final Point SEVEN = new Point(2, 2);
	private static final Point EIGHT = new Point(3, 2);
	private static final Point NINE = new Point(4, 2);
	private static final Point A = new Point(1, 1);
	private static final Point B = new Point(2, 1);
	private static final Point C = new Point(3, 1);
	private static final Point D = new Point(2, 0);

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
		getNumberMap().putIfAbsent(A, "A");
		getNumberMap().putIfAbsent(B, "B");
		getNumberMap().putIfAbsent(C, "C");
		getNumberMap().putIfAbsent(D, "D");
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
}
