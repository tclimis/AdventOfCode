package com.adventofcode.y2016.day2;

import java.awt.Point;
import java.util.HashMap;

public class Day2Challenge2 extends Day2Challenge1 {

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
	protected void setupNumberMap() {
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
	
}
