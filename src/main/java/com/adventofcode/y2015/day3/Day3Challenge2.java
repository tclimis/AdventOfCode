package com.adventofcode.y2015.day3;

import java.awt.Point;

public class Day3Challenge2 extends Day3Challenge1 {

	private Point roboSantaLocation = new Point();
	
	@Override
	public void initialize() {
		super.initialize();
		initializeRoboSantaLocation();
	}

	private void initializeRoboSantaLocation() {
		roboSantaLocation.setLocation(0, 0);
	}
	
	@Override
	public void processLine(String input) {
		for( int i = 0; i < input.length(); i++ ) {
			if( i % 2 == 0 ) {
				moveSanta(input.charAt(i));
				recordVisit(getSantaLocation());
			}
			else {
				moveRoboSanta(input.charAt(i));
				recordVisit(getRoboSantaLocation());
			}
		}
	}

	private void moveRoboSanta(char direction) {
		move(getRoboSantaLocation(), direction);
	}

	private Point getRoboSantaLocation() {
		return roboSantaLocation;
	}

}
